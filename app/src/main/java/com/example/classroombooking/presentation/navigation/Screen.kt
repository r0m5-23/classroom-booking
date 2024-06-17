package com.example.classroombooking.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    object ClassroomSelection: Screen()

    @Serializable
    data class ClassroomDetailsVisualization(
        val name: String
    ): Screen()
}