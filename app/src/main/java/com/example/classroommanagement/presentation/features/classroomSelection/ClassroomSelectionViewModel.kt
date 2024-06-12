package com.example.classroommanagement.presentation.features.classroomSelection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classroommanagement.domain.repositories.BuildingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ClassroomSelectionViewModel @Inject constructor(
    private val buildingRepository: BuildingRepository
) : ViewModel() {
    private val _buildingsWithClassrooms = buildingRepository.getBuildingsWithClassrooms()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _state = MutableStateFlow(ClassroomSelectionUiState())

    val state = combine(_state, _buildingsWithClassrooms) { state, buildingsWithClassrooms ->
        state.copy(
            buildingsWithClassrooms = buildingsWithClassrooms
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ClassroomSelectionUiState())

    fun onEvent(event: ClassroomSelectionUiEvent) {
        when (event) {
            ClassroomSelectionUiEvent.SearchClassroom -> TODO()

            is ClassroomSelectionUiEvent.SetSearchText -> {
                _state.update {
                    it.copy(
                        searchText = event.searchText
                    )
                }
            }

            is ClassroomSelectionUiEvent.SelectClassroom -> {
                _state.update { it.copy(
                    isClassroomSelected = true
                ) }
                println("Classroom selected")
            }
        }
    }
}