package com.example.classroommanagement.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buildings")
data class BuildingEntity (
    @PrimaryKey(autoGenerate = true) val buildingId: Int,
    val buildingName: String
)