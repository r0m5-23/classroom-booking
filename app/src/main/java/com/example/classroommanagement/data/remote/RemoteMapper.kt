package com.example.classroommanagement.data.remote

import com.example.classroommanagement.data.local.entities.BuildingEntity
import com.example.classroommanagement.data.local.entities.ClassroomEntity
import com.example.network.response.dtos.BuildingDto
import com.example.network.response.dtos.ClassroomDto

fun ClassroomDto.asClassroomEntity() : ClassroomEntity {
    return ClassroomEntity(
        classroomId = id!!,
        classroomName = name!!,
        buildingId = building!!.id!!
    )
}

fun BuildingDto.asBuildingEntity() : BuildingEntity {
    return BuildingEntity(
        buildingId = id!!,
        buildingName = name!!
    )
}

