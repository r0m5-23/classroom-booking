package com.example.classroommanagement.presentation.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classroommanagement.ui.theme.SmallHeadingStyle
import java.time.LocalDateTime

data class Event(
    val name: String,
    val color: Color,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val teacher: String,
    val typology: String,
    val course: String
)

@Composable
fun ScheduleEvent(
    event: Event,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = event.color //MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = event.name,
                style = SmallHeadingStyle
            )
            Text(
                text = event.typology,
                style = SmallHeadingStyle
            )
            Text(
                text = event.course,
                style = SmallHeadingStyle
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScheduleEventPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScheduleEvent(
            modifier = Modifier
                .width(350.dp)
                .height(120.dp),
            event = Event(
                name = "Teste",
                color = Color(0xFFEEE8AA),
                startTime = LocalDateTime.parse("2021-05-18T13:00:00"),
                endTime = LocalDateTime.parse("2021-05-18T15:00:00"),
                teacher = "Professor",
                typology = "Topologia",
                course = "Curso"
            )
        )
    }
}