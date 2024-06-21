package com.example.classroombooking.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    object ClassroomSelection: Screen()

    @Serializable
    data class ClassroomSchedule(
        val name: String
    ): Screen()
}