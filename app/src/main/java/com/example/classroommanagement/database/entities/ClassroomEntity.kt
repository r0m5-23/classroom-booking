package com.example.classroommanagement.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classrooms")
data class ClassroomEntity(
    @PrimaryKey(autoGenerate = true) val classroomId: Int = 0,
    val classroomName: String,
    val buildingId: Int
)
