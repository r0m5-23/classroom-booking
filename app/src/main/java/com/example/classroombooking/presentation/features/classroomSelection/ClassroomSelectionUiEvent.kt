package com.example.classroombooking.presentation.features.classroomSelection

import com.example.classroombooking.domain.models.Classroom

sealed interface ClassroomSelectionUiEvent {
    object SearchClassroom: ClassroomSelectionUiEvent
    data class SetSearchText(val searchText: String): ClassroomSelectionUiEvent
    data class SelectClassroom(val classroom: Classroom): ClassroomSelectionUiEvent
}