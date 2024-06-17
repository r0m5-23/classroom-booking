package com.example.classroombooking.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.classroombooking.domain.models.Classroom

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


