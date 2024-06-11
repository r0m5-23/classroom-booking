package com.example.classroommanagement.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.classroommanagement.data.local.entities.ClassroomEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClassroomDAO {
    @Upsert
    suspend fun upsertClassrooms(classroomsList: List<ClassroomEntity>)

    @Query("SELECT * FROM classrooms WHERE classroomId = :roomId")
    fun getClassroomById(roomId: Int): Flow<ClassroomEntity>

    @Query("SELECT * FROM classrooms")
    fun getClassrooms(): Flow<List<ClassroomEntity>>
}