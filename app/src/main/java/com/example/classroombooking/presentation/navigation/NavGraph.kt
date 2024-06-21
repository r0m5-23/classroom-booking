package com.example.classroombooking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.classroom_schedule.ClassroomScheduleScreen
import com.example.classroom_selection.ClassroomSelectionScreen
import com.example.classroom_selection.ClassroomSelectionViewModel

@Composable
fun SetupNavGraph(
    classroomSelectionViewModel: ClassroomSelectionViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    val state by classroomSelectionViewModel.state.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.ClassroomSelection,
    ) {
        composable<Screen.ClassroomSelection> {
            ClassroomSelectionScreen(navController = navController, state = state, onEvent = classroomSelectionViewModel::onEvent)
        }
        composable<Screen.ClassroomSchedule> { navBackStackEntry ->
            val args = navBackStackEntry.toRoute<Screen.ClassroomSchedule>()
            ClassroomScheduleScreen(
                classroomName = args.name
            )
        }
    }
}