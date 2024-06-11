package com.example.classroommanagement.domain.repositories

import com.example.classroommanagement.domain.models.Building
import com.example.classroommanagement.domain.models.BuildingWithClassrooms
import kotlinx.coroutines.flow.Flow

interface BuildingRepository {
    suspend fun upsertBuildings(buildings: List<Building>)
    fun getBuildingById(id:Int): Flow<Building>
    fun getBuildings(): Flow<List<Building>>
    fun getBuildingsWithClassrooms(): Flow<List<BuildingWithClassrooms>>
}