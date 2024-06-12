package com.example.classroommanagement.presentation.features.classroomSelection

import com.example.classroommanagement.domain.models.BuildingWithClassrooms

data class ClassroomSelectionUiState(
    val buildingsWithClassrooms: List<BuildingWithClassrooms> = emptyList(),
    val searchText: String = "",
    val isSearching: Boolean = false,
    val isClassroomSelected: Boolean = false
)
