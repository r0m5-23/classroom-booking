package com.example.classroombooking.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.classroombooking.domain.models.Building

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