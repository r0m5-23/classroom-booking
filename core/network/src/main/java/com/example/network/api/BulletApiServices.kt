package com.example.network.api

import com.example.network.response.NetworkResponse
import com.example.network.response.dtos.ClassroomDto
import com.example.network.response.dtos.EventDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BulletApiServices {

    @GET("api/Classrooms/active/basicinformation")
    suspend fun getClassroomsActiveBasicInformation(): NetworkResponse<List<ClassroomDto>>

    @GET("api/Classrooms/{id}")
    suspend fun getClassroomById(
        @Path("id") id: Int?
    ): NetworkResponse<ClassroomDto>

    @GET("/api/Events/all/{startDate}/{endDate}/{classroomId}")
    suspend fun getEventsByClassroomIdAndDateRange(
        @Path("startDate") startDate: String?,
        @Path("endDate") endDate: String?,
        @Path("classroomId") classroomId: Int?,
    ): NetworkResponse<List<EventDto>>

    @GET("api/Events/{id}")
    suspend fun getEventById(
        @Path("id") id: Int?
    ): NetworkResponse<EventDto>
}