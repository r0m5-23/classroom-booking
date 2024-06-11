package com.example.classroommanagement.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.classroommanagement.domain.models.Classroom

@Entity(tableName = "classrooms")
data class ClassroomEntity(
    @PrimaryKey
    val classroomId: Int,
    val classroomName: String,
    val buildingId: Int
)

fun ClassroomEntity.asClassroom(): Classroom {
    return Classroom(
        id = classroomId,
        name = classroomName,
        buildingId = buildingId,
    )
}


