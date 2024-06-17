package com.example.classroombooking.presentation.features.classroomSelection

import com.example.classroombooking.domain.models.BuildingWithClassrooms

data class ClassroomSelectionUiState(
    val buildingsWithClassrooms: List<BuildingWithClassrooms> = emptyList(),
    val searchText: String = "",
    val isSearching: Boolean = false,
    val isClassroomSelected: Boolean = false
)
