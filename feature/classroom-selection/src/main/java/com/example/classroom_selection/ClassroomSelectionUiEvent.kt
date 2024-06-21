package com.example.classroom_selection

import com.example.domain.models.Classroom

sealed interface ClassroomSelectionUiEvent {
    object SearchClassroom: ClassroomSelectionUiEvent
    data class SetSearchText(val searchText: String): ClassroomSelectionUiEvent
    data class SelectClassroom(val classroom: Classroom): ClassroomSelectionUiEvent
}