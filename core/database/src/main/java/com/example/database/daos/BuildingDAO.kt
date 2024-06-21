package com.example.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.database.entities.BuildingEntity
import com.example.database.entities.BuildingWithClassroomsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BuildingDAO {

    @Upsert
    suspend fun upsertBuildings(buildingsList: List<BuildingEntity>)

    @Query("SELECT * FROM buildings WHERE buildingId = :buildingId")
    fun getBuildingById(buildingId: Int): Flow<BuildingEntity>

    @Query("SELECT * FROM buildings")
    fun getBuildings(): Flow<List<BuildingEntity>>

    @Transaction
    @Query("SELECT * FROM buildings")
    fun getBuildingsWithRooms(): Flow<List<BuildingWithClassroomsEntity>>
}