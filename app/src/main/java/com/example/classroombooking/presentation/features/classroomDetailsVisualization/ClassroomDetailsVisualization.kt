package com.example.classroombooking.presentation.features.classroomDetailsVisualization

import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classroombooking.presentation.features.components.ClassroomDetailsHeader
import com.example.classroombooking.presentation.features.components.ClassroomDetailsSchedule
import com.example.classroombooking.presentation.features.components.DateHeader
import com.example.classroombooking.presentation.features.components.DatePickerUI
import com.example.classroombooking.presentation.features.components.Event
import com.example.classroombooking.presentation.features.components.ScheduleEvent
import com.example.classroombooking.presentation.features.components.TimeSidebarLabel
import com.example.classroombooking.presentation.features.components.TimeSlot
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Composable
fun ClassroomDetailsVisualizationScreen(
    classroomName: String,
    modifier: Modifier = Modifier
){
    val isPortrait = Resources.getSystem().configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    val minDate = LocalDate.of(2024, 6, 10)
    var dateItemsCount = 7
    val hours = (8..23).toList()

    var dateHeaderWidth = 132.dp
    var timeSlotHeight = 50.dp

    if (isPortrait) {
        dateItemsCount = 1
        timeSlotHeight = 60.dp
        dateHeaderWidth = 350.dp
    }

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

    Scaffold (
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Reservar") },
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add") },
                onClick = { /*TODO*/ },
                containerColor = Color(0xFFEEE8AA)
            )
        }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(Modifier.height(8.dp))
            ClassroomDetailsHeader(buildingName = "ETC - Polo I", classroomName = classroomName)
            Spacer(Modifier.height(16.dp))
            Row {
                Spacer(modifier = Modifier.width((54.5).dp))
                DatePickerUI(
                    modifier = Modifier
                        .height(30.dp)
                        .width(dateHeaderWidth)
                )
            }
            ClassroomDetailsSchedule(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .horizontalScroll(rememberScrollState()),
                timeSidebar = {
                    Column {
                        hours.forEach {
                            TimeSidebarLabel(
                                time = LocalTime.of(it,0),
                                modifier = Modifier.height(timeSlotHeight)
                            )
                        }
                    }
                },
                dateItemsCount = dateItemsCount,
                dateHeader = { dateIndex ->
                    val date = minDate.plusDays(dateIndex.toLong())
                    DateHeader(
                        date = date,
                        modifier = Modifier.width(dateHeaderWidth)
                    )
                },
                dateTimeSlots = { dateIndex ->
                    Column {
                        hours.forEach {
                            TimeSlot(it, modifier = Modifier.height(timeSlotHeight))
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
}

@Preview(showBackground = true, widthDp = 500)
@Composable
private fun ClassroomDetailsVisualizationScreenPreview(){
    ClassroomDetailsVisualizationScreen("Sala1")
}