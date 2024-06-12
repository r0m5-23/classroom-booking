package com.example.classroommanagement.presentation.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimeSlot(
    index: Int,
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .background(
                color = if (index % 2 == 0) Color.LightGray.copy(alpha = 0.2f) else Color.LightGray.copy(
                    alpha = 0.5f
                )
            )
            .border( // Add border here
                width = 1.dp, // Border width
                color = Color.White // Border color
            )

    )
}

@Preview(showBackground = true)
@Composable
fun TimeSlotPreview() {
    val hours = (8..23).toList()

    Column {
        hours.forEach{
            TimeSlot(it, modifier = Modifier.height(60.dp).width(350.dp))
        }
    }
}