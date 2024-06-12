@file:OptIn(ExperimentalFoundationApi::class)

package com.example.classroommanagement.presentation.features.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.classroommanagement.domain.models.BuildingWithClassrooms
import com.example.classroommanagement.domain.models.Classroom

@Composable
fun BuildingHeader(
    buildingName: String,
    modifier: Modifier = Modifier
){
    Text(
        text = buildingName,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)

    )
}

@Preview(showBackground = true)
@Composable
private fun BuildingHeaderPreview(){
    BuildingHeader(buildingName = "Edifício 1")
}

@Composable
fun ClassroomItem(
    classroomName: String,
    modifier: Modifier = Modifier
){
    Text(
        text = classroomName,
        fontSize = 18.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun ClassroomItemPreview() {
    ClassroomItem("Sala 1")
}

@Composable
fun LazyColumnWithHeaders(
    modifier: Modifier = Modifier,
    list: List<BuildingWithClassrooms>,
    onItemClick: (Classroom) -> Unit
){
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        list.forEach { buildingWithClassrooms ->
            stickyHeader {
                BuildingHeader(buildingName = buildingWithClassrooms.buildingName)
            }
            items(buildingWithClassrooms.classrooms){ classroom ->
                ClassroomItem(
                    classroomName = classroom.name,
                    modifier = Modifier.clickable {
                        onItemClick(classroom)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnWithHeadersPreview() {

    val list = listOf(
        BuildingWithClassrooms(
            buildingName = "Edifício1",
            classrooms = listOf(
                Classroom(0, "Sala1", 0)
            )
        ),
        BuildingWithClassrooms(
            buildingName = "Edifício2",
            classrooms = listOf(
                Classroom(1, "Sala2", 1),
                Classroom(2, "Sala3", 1),
            )
        ),
        BuildingWithClassrooms(
            buildingName = "Edifício3",
            classrooms = listOf(
                Classroom(3, "Sala4", 2),
                Classroom(4, "Sala5", 2),
                Classroom(5, "Sala6", 2),
            )
        )
    )

    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumnWithHeaders(
            list = list,
            onItemClick = {}
        )
    }


}