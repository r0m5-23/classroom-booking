package com.example.classroom_selection

import com.example.domain.models.BuildingWithClassrooms

data class ClassroomSelectionUiState(
    val buildingsWithClassrooms: List<BuildingWithClassrooms> = emptyList(),
    val searchText: String = "",
    val isSearching: Boolean = false,
    val isClassroomSelected: Boolean = false
)
