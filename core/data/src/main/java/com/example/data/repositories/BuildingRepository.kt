package com.example.data.repositories

import com.example.domain.models.Building
import com.example.domain.models.BuildingWithClassrooms
import kotlinx.coroutines.flow.Flow

interface BuildingRepository {
    suspend fun upsertBuildings(buildings: List<Building>)
    fun getBuildingById(id:Int): Flow<Building>
    fun getBuildings(): Flow<List<Building>>
    fun getBuildingsWithClassrooms(): Flow<List<BuildingWithClassrooms>>
}