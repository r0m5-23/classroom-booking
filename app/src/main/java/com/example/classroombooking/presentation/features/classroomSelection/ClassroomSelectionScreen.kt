package com.example.classroombooking.presentation.features.classroomSelection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.classroombooking.R
import com.example.classroombooking.presentation.features.components.LazyColumnWithHeaders
import com.example.classroombooking.presentation.features.components.SearchBarUI
import com.example.classroombooking.presentation.navigation.Screen

@Composable
fun ClassroomSelectionScreen(
    navController: NavController,
    state: ClassroomSelectionUiState,
    onEvent: (ClassroomSelectionUiEvent) -> Unit
){
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.height(16.dp))
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.logo_utad_preto),
            contentDescription = "Logo",
            modifier = Modifier
                .width(120.dp)
                .aspectRatio(2f / 1f)
                .align(Alignment.CenterHorizontally),
        )
        Spacer(Modifier.height(16.dp))
        SearchBarUI(
            placeholder = "Search classroom",
        )
        Spacer(Modifier.height(16.dp))
        LazyColumnWithHeaders(
            list = state.buildingsWithClassrooms,
            onItemClick = {
                onEvent(ClassroomSelectionUiEvent.SelectClassroom(it))
                navController.navigate(
                    Screen.ClassroomDetailsVisualization(
                        it.name
                    )
                )
            }
        )
    }
}
