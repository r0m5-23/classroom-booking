package com.example.classroommanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.classroommanagement.presentation.features.classroomSelection.ClassroomSelectionViewModel
import com.example.classroommanagement.presentation.navigation.SetupNavGraph
import com.example.classroommanagement.ui.theme.ClassroomManagementTheme
import com.example.network.repository.RemoteDataSourceRepository
import com.example.network.response.dtos.ClassroomDto
import com.example.network.response.dtos.EventDto
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
    ClassroomManagementTheme {
        val navController = rememberNavController()
        val classroomSelectionViewModel = hiltViewModel<ClassroomSelectionViewModel>()

        Scaffold(modifier = Modifier.fillMaxSize()) {
            SetupNavGraph(classroomSelectionViewModel = classroomSelectionViewModel, navController = navController, modifier = Modifier.padding(it))
        }
    }
}
