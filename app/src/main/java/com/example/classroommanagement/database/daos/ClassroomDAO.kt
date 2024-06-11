package com.example.classroommanagement.database.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.classroommanagement.database.entities.ClassroomEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClassroomDAO {
    @Upsert
    suspend fun upsertClassrooms(classroomsList: List<ClassroomEntity>)

    @Upsert
    suspend fun upsertClassroom(classroomEntity: ClassroomEntity)

    @Query("SELECT * FROM classrooms WHERE classroomId = :roomId")
    suspend fun getRoomById(roomId: Int): ClassroomEntity

    @Query("SELECT * FROM classrooms")
    fun getRooms(): Flow<List<ClassroomEntity>>
}