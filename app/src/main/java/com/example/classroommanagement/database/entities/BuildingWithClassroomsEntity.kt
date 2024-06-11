package com.example.classroommanagement.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class BuildingWithClassroomsEntity(
    @Embedded val buildingEntity: BuildingEntity,
    @Relation(
        parentColumn = "buildingId",
        entityColumn = "buildingId"
    )
    val classrooms: List<ClassroomEntity>
)
