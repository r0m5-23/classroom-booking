package com.example.classroommanagement.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.classroommanagement.database.entities.BuildingEntity
import com.example.classroommanagement.database.entities.BuildingWithClassroomsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BuildingDAO {

    @Upsert
    suspend fun upsertBuildings(buildingsList: List<BuildingEntity>)

    @Upsert
    suspend fun upsertBuilding(buildingEntity: BuildingEntity)

    @Query("SELECT * FROM buildings WHERE buildingId = :buildingId")
    suspend fun getBuildingById(buildingId: Int): BuildingEntity

    @Query("SELECT * FROM buildings")
    fun getBuildings(): Flow<List<BuildingEntity>>

    @Transaction
    @Query("SELECT * FROM buildings")
    fun getBuildingsWithRooms(): Flow<List<BuildingWithClassroomsEntity>>
}