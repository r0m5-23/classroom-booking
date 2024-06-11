package com.example.network.repository

import com.example.network.response.dtos.ClassroomDto
import com.example.network.response.dtos.EventDto
import com.example.network.api.BulletApiServices
import javax.inject.Inject

class RemoteDataSourceRepositoryImpl @Inject constructor(
    private val bulletApi: BulletApiServices
) : RemoteDataSourceRepository {

    override suspend fun getClassrooms(): List<ClassroomDto> {
        return bulletApi.getClassroomsActiveBasicInformation().data
    }

    override suspend fun getClassroomById(id: Int?): ClassroomDto {
        return bulletApi.getClassroomById(id = id).data
    }

    override suspend fun getEventsByClassroomIdAndDateRange(
        startDate: String?,
        endDate: String?,
        classroomId: Int?
    ): List<EventDto> {
        return bulletApi.getEventsByClassroomIdAndDateRange(startDate, endDate, classroomId).data
    }

    override suspend fun getEventById(id: Int?): EventDto {
        return bulletApi.getEventById(id).data
    }
}