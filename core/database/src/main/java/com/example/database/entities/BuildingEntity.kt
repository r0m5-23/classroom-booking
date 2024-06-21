package com.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Building

@Entity(tableName = "buildings")
data class BuildingEntity (
    @PrimaryKey
    val buildingId: Int,
    val buildingName: String
)

fun BuildingEntity.asBuilding(): Building {
    return Building(
        id = buildingId,
        name = buildingName
    )
}