package com.example.classroommanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
            var rooms by remember {
                mutableStateOf<List<ClassroomDto>?>(emptyList())
            }

            var room by remember {
                mutableStateOf<ClassroomDto?>(null)
            }

            var events by remember {
                mutableStateOf<List<EventDto>?>(emptyList())
            }

            var event by remember {
                mutableStateOf<EventDto?>(null)
            }

            LaunchedEffect(key1 = Unit) {
                var eventsIds = mutableListOf<Int>()

                rooms = remoteDataSourceRepository.getClassrooms()
                room = remoteDataSourceRepository.getClassroomById(179)
                events = remoteDataSourceRepository.getEventsByClassroomIdAndDateRange("2024-06-06", "2024-06-07", room?.id)
                events?.forEach {
                    eventsIds.add(it.id!!)
                }
                event = remoteDataSourceRepository.getEventById(eventsIds.last())
            }

            ClassroomManagementTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(rooms?.size, room?.name, events?.size, event?.module?.name, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(rooms: Int?, roomName: String?, events: Int?, eventName: String?, modifier: Modifier = Modifier) {
    if(roomName.isNullOrEmpty()){
        Text(
            text = "Hello Android!",
            modifier = modifier,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
    } else {
        Text(
            text =  "Hello!\n" +
                    "\nThere are $rooms active rooms.\n"+
                    "\nThis is room $roomName!\n" +
                    "\nI have $events events for the rest of the week.\n" +
                    "\nMy last event of the week will be: $eventName.",
            modifier = modifier,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClassroomManagementTheme {
        Greeting(0, "Android", 0, "x")
    }
}