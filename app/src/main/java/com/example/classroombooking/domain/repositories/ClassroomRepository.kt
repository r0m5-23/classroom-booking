package com.example.classroombooking.domain.repositories

import com.example.classroombooking.domain.models.Classroom
import kotlinx.coroutines.flow.Flow

interface ClassroomRepository {
    suspend fun upsertClassrooms(classrooms: List<Classroom>)
    fun getClassroomById(id: Int): Flow<Classroom>
    fun getClassrooms(): Flow<List<Classroom>>
}