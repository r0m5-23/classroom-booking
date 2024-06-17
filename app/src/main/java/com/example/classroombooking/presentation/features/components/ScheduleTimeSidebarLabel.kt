package com.example.classroombooking.presentation.features.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classroombooking.ui.theme.SmallHeadingStyle
import java.time.LocalTime
import java.time.format.DateTimeFormatter

private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

@Composable
fun TimeSidebarLabel(
    // startTime: LocalTime,
    // endTime: LocalTime,
    time: LocalTime,
    modifier: Modifier = Modifier,
){
    Box (
        modifier = modifier
            .fillMaxHeight()
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            // text = "${startTime.format(timeFormatter)} - ${endTime.format(timeFormatter)}",
            text = time.format(timeFormatter),
            style = SmallHeadingStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimeSidebarLabelPreview(){
    val hours = (8..23).toList()

    Column {
        hours.forEach {
            TimeSidebarLabel(time = LocalTime.of(it,0), modifier = Modifier.height(60.dp))
        }
    }
}