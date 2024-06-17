package com.example.classroombooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.classroombooking.presentation.features.classroomSelection.ClassroomSelectionViewModel
import com.example.classroombooking.presentation.navigation.SetupNavGraph
import com.example.classroombooking.ui.theme.ClassroomBookingTheme
import com.example.network.repository.RemoteDataSourceRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var remoteDataSourceRepository: RemoteDataSourceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestApp()
        }
    }
}

@Composable
fun TestApp() {
    ClassroomBookingTheme {
        val navController = rememberNavController()
        val classroomSelectionViewModel = hiltViewModel<ClassroomSelectionViewModel>()

        Scaffold(modifier = Modifier.fillMaxSize()) {
            SetupNavGraph(classroomSelectionViewModel = classroomSelectionViewModel, navController = navController, modifier = Modifier.padding(it))
        }
    }
}
