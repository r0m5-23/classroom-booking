package com.example.classroommanagement.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.classroommanagement.domain.models.BuildingWithClassrooms

data class BuildingWithClassroomsEntity(
    @Embedded val buildingEntity: BuildingEntity,
    @Relation(
        parentColumn = "buildingId",
        entityColumn = "buildingId"
    )
    val classrooms: List<ClassroomEntity>
)

fun BuildingWithClassroomsEntity.asBuildingWithClassrooms(): BuildingWithClassrooms {
    return BuildingWithClassrooms(
        buildingName = buildingEntity.buildingName,
        classrooms = classrooms.map(ClassroomEntity::asClassroom)
    )
}
