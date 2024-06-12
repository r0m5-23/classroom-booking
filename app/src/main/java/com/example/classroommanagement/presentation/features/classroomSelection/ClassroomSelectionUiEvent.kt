package com.example.classroommanagement.presentation.features.classroomSelection

import com.example.classroommanagement.domain.models.Classroom

sealed interface ClassroomSelectionUiEvent {
    object SearchClassroom: ClassroomSelectionUiEvent
    data class SetSearchText(val searchText: String): ClassroomSelectionUiEvent
    data class SelectClassroom(val classroom: Classroom): ClassroomSelectionUiEvent
}