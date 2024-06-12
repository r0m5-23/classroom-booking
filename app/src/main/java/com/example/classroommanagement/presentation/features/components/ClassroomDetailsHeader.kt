package com.example.classroommanagement.presentation.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.classroommanagement.R

@Composable
fun ClassroomDetailsHeader(
    buildingName: String,
    classroomName: String,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier
            // .background(Color.Cyan)
        ) {
            Row{
                Text(
                    text = "Edifício: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = buildingName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Row{
                Text(
                    text = "Sala: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = classroomName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.logo_utad_preto),
            contentDescription = "Logo",
            modifier = modifier
                .width(120.dp)
                .aspectRatio(2f / 1f),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ClassroomDetailsHeaderPreview(){
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        ClassroomDetailsHeader(
            buildingName = "ECT - Polo I",
            classroomName = "F1.01"
        )
    }
}