package com.example.classroommanagement.data.repositories

import com.example.classroommanagement.data.local.daos.ClassroomDAO
import com.example.classroommanagement.data.local.entities.ClassroomEntity
import com.example.classroommanagement.data.local.entities.asClassroom
import com.example.classroommanagement.data.remote.asClassroomEntity
import com.example.classroommanagement.domain.models.Classroom
import com.example.classroommanagement.domain.repositories.ClassroomRepository
import com.example.network.repository.RemoteDataSourceRepository
import com.example.network.response.dtos.ClassroomDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ClassroomRepositoryImp @Inject constructor(
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