package com.example.data.repositories

import com.example.data.remote.asClassroomEntity
import com.example.database.daos.ClassroomDAO
import com.example.database.entities.ClassroomEntity
import com.example.database.entities.asClassroom
import com.example.domain.models.Classroom
import com.example.network.repository.RemoteDataSourceRepository
import com.example.network.response.dtos.ClassroomDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ClassroomRepositoryImpl @Inject constructor(
    private val classroomDAO: ClassroomDAO,
    private val remoteDataSourceRepository: RemoteDataSourceRepository
): ClassroomRepository {
    override suspend fun upsertClassrooms(classrooms: List<Classroom>) {
        // TODO() Synchronizer
        val networkClassrooms = remoteDataSourceRepository.getClassrooms()
        return classroomDAO.upsertClassrooms(networkClassrooms.map(ClassroomDto::asClassroomEntity))
    }

    override fun getClassroomById(id: Int): Flow<Classroom> {
        return classroomDAO.getClassroomById(id).map { it.asClassroom() }
    }

    override fun getClassrooms(): Flow<List<Classroom>> {
        return classroomDAO.getClassrooms().map { it.map(ClassroomEntity::asClassroom) }
    }
}