package com.example.network.repository

import com.example.network.response.dtos.ClassroomDto
import com.example.network.response.dtos.EventDto
import com.example.network.api.BulletApiServices
import com.example.network.response.dtos.BuildingDto
import javax.inject.Inject

class RemoteDataSourceRepositoryImpl @Inject constructor(
    private val bulletApi: BulletApiServices
) : RemoteDataSourceRepository {
    override suspend fun getBuildings(): List<BuildingDto> {
        return bulletApi.getBuildingsActive().data
    }

    override suspend fun getClassrooms(): List<ClassroomDto> {
        return bulletApi.getClassroomsActiveBasicInformation().data
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