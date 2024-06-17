package com.example.classroombooking.presentation.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classroombooking.ui.theme.SmallHeadingStyle
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun DateHeader(
    date: LocalDate,
    modifier: Modifier = Modifier
){
    val formattedDate = date.format(DateTimeFormatter.ofPattern("EE dd-MM-yyyy", Locale("pt")))
    val formattedDateFinal = formattedDate.replaceFirstChar { it.uppercase() }
    Box (
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.DarkGray.copy(alpha = 0.8f)
            )
            .border( // Add border here
                width = 1.dp, // Border width
                color = Color.White // Border color
            ),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = formattedDateFinal,
            color = Color.White,
            modifier = modifier.padding(vertical = 16.dp),
            textAlign = TextAlign.Center,
            style = SmallHeadingStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DateHeaderPreview(){
    DateHeader(date = LocalDate.now(), modifier = Modifier.width(128.dp))
}