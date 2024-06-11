package com.example.network.repository

import com.example.network.response.dtos.ClassroomDto
import com.example.network.response.dtos.EventDto

interface RemoteDataSourceRepository {

    suspend fun getClassrooms(): List<ClassroomDto>
    suspend fun getClassroomById(id: Int? = null): ClassroomDto
    suspend fun getEventsByClassroomIdAndDateRange(
        startDate: String? = null,
        endDate: String? = null,
        classroomId: Int? = null
    ): List<EventDto>

    suspend fun getEventById(id: Int? = null): EventDto
}