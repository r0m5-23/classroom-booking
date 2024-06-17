package com.example.classroombooking.presentation.features.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import kotlin.math.roundToInt

@Composable
fun ClassroomDetailsSchedule(
    timeSidebar: @Composable () -> Unit,
    dateItemsCount: Int,
    dateHeader: @Composable (dateIndex: Int) -> Unit,
    dateTimeSlots: @Composable (dateIndex: Int) -> Unit,
    events: List<Event>,
    eventContent: @Composable ClassroomScheduleScope.(event: Event) -> Unit,
    modifier: Modifier = Modifier
){
    val datesHeader = @Composable { repeat(dateItemsCount) { dayIndex -> dateHeader(dayIndex)} }
    val datesTimeSlots = @Composable { repeat(dateItemsCount) { dateIndex -> dateTimeSlots(dateIndex)} }
    val eventsContent = @Composable { repeat(events.size) { ClassroomScheduleScope.eventContent(events[it])} }

    Layout(
        contents = listOf(timeSidebar, datesHeader, datesTimeSlots, eventsContent),
        modifier = modifier
    ) {(timeSidebarMeasurables, dateHeaderMeasurables, dateTimeSlotsMeasurables, eventContentMeasurables),
       constraints ->

        // 1. Measurement step
        // Determine sizes of components

        // timeSidebar measurement
        require(timeSidebarMeasurables.size == 1) {
            "timeSidebar should only emit one composable"
        }
        val timeSidebarPlaceable = timeSidebarMeasurables.first().measure(constraints)

        var totalWidth = timeSidebarPlaceable.width

        // dateHeader measurement
        val dateHeaderPlaceables = dateHeaderMeasurables.map { measurable ->
            val placeable = measurable.measure(constraints)
            placeable
        }

        // dateTimeSlots measurement
        val dateTimeSlotsPlaceables = dateTimeSlotsMeasurables.map { measurable ->
            val dateTimeSlotsWidth = dateHeaderPlaceables.first().width
            val dateTimeSlotsHeight = timeSidebarPlaceable.height
            val placeable = measurable.measure(
                constraints.copy(
                    minWidth = dateTimeSlotsWidth,
                    maxWidth = dateTimeSlotsWidth,
                    minHeight = dateTimeSlotsHeight,
                    maxHeight = dateTimeSlotsHeight
                )
            )
            totalWidth += placeable.width
            placeable
        }

        // event measurement
        val eventContentPlaceables = eventContentMeasurables.map { measurable ->
            val eventContentWidth = dateHeaderPlaceables.first().width
            val eventContentParentData = measurable.parentData as ClassroomScheduleParentData
            val eventContentHeight = (eventContentParentData.duration * timeSidebarPlaceable.height).roundToInt()
            val placeable = measurable.measure(constraints.copy(
                minWidth = eventContentWidth,
                maxWidth = eventContentWidth,
                minHeight = eventContentHeight,
                maxHeight = eventContentHeight
            ))
            placeable
        }

        val totalHeight = dateHeaderPlaceables.first().height + timeSidebarPlaceable.height

        // Set the size of the layout as big as it can
        layout(totalWidth, totalHeight){
            var xPosition = timeSidebarPlaceable.width
            val yPosition = dateHeaderPlaceables.first().height
            val xEventPosition = timeSidebarPlaceable.width

            // timeSidebar placement
            timeSidebarPlaceable.place(x = 0, y = yPosition)

            // dateTimeSlots placement
            dateTimeSlotsPlaceables.forEachIndexed { index, placeable ->
                // placeable.parentData as ScheduleFinalParentData
                placeable.place(x = xPosition, y = yPosition)

                // dateHeader placement
                val dateHeaderPlaceable = dateHeaderPlaceables[index]
                dateHeaderPlaceable.place(x = xPosition, y = 0)

                xPosition += placeable.width
            }

            // event placement
            var eventCount = 0
            eventContentPlaceables.forEach { placeable ->
                val eventParentData = placeable.parentData as ClassroomScheduleParentData
                val eventOffsetX = (eventParentData.offsetX * dateHeaderPlaceables.first().width)
                val eventOffsetY = (eventParentData.offsetY * timeSidebarPlaceable.height).roundToInt()

                placeable.place(x = xEventPosition + eventOffsetX,y= yPosition + eventOffsetY)
            }

        }
    }
}

private class ClassroomScheduleParentData(
    // measure height
    val duration: Float,
    // width placement
    val offsetX: Int,
    // height placement
    val offsetY: Float
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?): Any {
        return this@ClassroomScheduleParentData
    }
}

@LayoutScopeMarker
@Immutable
object ClassroomScheduleScope {
    @Stable
    fun Modifier.classroomScheduleEvent(
        startTime: LocalDateTime,
        endTime: LocalDateTime,
        hours: List<Int>
    ): Modifier {
        val earliestTime = LocalTime.of(hours.first(), 0)
        val durationInHours = ChronoUnit.MINUTES.between(startTime, endTime) / 60f
        val durationFromEarliestToStartInHours = ChronoUnit.MINUTES.between(earliestTime, startTime.toLocalTime()) / 60f
        val offsetInHours = durationFromEarliestToStartInHours
        val earliestDay = startTime.toLocalDate().with(DayOfWeek.MONDAY)
        val offsetInDays = ChronoUnit.DAYS.between(earliestDay, startTime.toLocalDate()).toInt()
        return then(
            ClassroomScheduleParentData(
                duration = durationInHours / hours.size,
                offsetX = offsetInDays,
                offsetY = offsetInHours / hours.size
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClassroomSchedulePreview(){
    val minDate = LocalDate.of(2024, 6, 10)
    val hours = (8..23).toList()

    val sampleEvents = listOf(
        Event(
            name = "Nome",
            color = Color(0xFFEEE8AA),
            startTime = LocalDateTime.parse("2024-06-10T11:00:00"),
            endTime = LocalDateTime.parse("2024-06-10T13:00:00"),
            teacher = "Professor",
            typology = "Topologia",
            course = "Curso"
        ),
        Event(
            name = "Nome1",
            color = Color(0xFFEEE8AA),
            startTime = LocalDateTime.parse("2024-06-11T15:00:00"),
            endTime = LocalDateTime.parse("2024-06-11T17:00:00"),
            teacher = "Professor1",
            typology = "Topologia1",
            course = "Curso1"
        ),
        Event(
            name = "Nome2",
            color = Color(0xFFEEE8AA),
            startTime = LocalDateTime.parse("2024-06-12T16:00:00"),
            endTime = LocalDateTime.parse("2024-06-12T17:00:00"),
            teacher = "Professor2",
            typology = "Topologia2",
            course = "Curso2"),
        Event(
            name = "Nome3",
            color = Color(0xFFEEE8AA),
            startTime = LocalDateTime.parse("2024-06-13T09:00:00"),
            endTime = LocalDateTime.parse("2024-06-13T11:00:00"),
            teacher = "Professor3",
            typology = "Topologia3",
            course = "Curso3"),
        Event(
            name = "Nome4",
            color = Color(0xFFEEE8AA),
            startTime = LocalDateTime.parse("2024-06-14T18:00:00"),
            endTime = LocalDateTime.parse("2024-06-14T20:00:00"),
            teacher = "Professor4",
            typology = "Topologia4",
            course = "Curso4"),
        Event(
            name = "Nome5",
            color = Color(0xFFEEE8AA),
            startTime = LocalDateTime.parse("2024-06-15T09:00:00"),
            endTime = LocalDateTime.parse("2024-06-15T11:00:00"),
            teacher = "Professor5",
            typology = "Topologia5",
            course = "Curso5"),
        Event(
            name = "Nome6",
            color = Color(0xFFEEE8AA),
            startTime = LocalDateTime.parse("2024-06-16T18:00:00"),
            endTime = LocalDateTime.parse("2024-06-16T20:00:00"),
            teacher = "Professor6",
            typology = "Topologia6",
            course = "Curso6"),
    )

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        ClassroomDetailsSchedule(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .horizontalScroll(rememberScrollState()),
            timeSidebar = {
                Column {
                    hours.forEach {
                        TimeSidebarLabel(
                            time = LocalTime.of(it,0),
                            modifier = Modifier.height(60.dp)
                        )
                    }
                }
             },
            dateItemsCount = 7,
            dateHeader = { dateIndex ->
                val date = minDate.plusDays(dateIndex.toLong())
                DateHeader(
                    date = date,
                    modifier = Modifier.width(132.dp)
                )
            },
            dateTimeSlots = { dateIndex ->
                Column {
                    hours.forEach {
                        TimeSlot(it, modifier = Modifier.height(60.dp))
                    }
                }
            },
            events = sampleEvents,
            eventContent = {
                ScheduleEvent(
                    event = it,
                    modifier = Modifier.classroomScheduleEvent(
                        startTime = it.startTime,
                        endTime= it.endTime,
                        hours = (8..23).toList()
                    )
                )
            }
        )
    }
}