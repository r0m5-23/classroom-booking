package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CurricularPlanDto(
    val code: String? = null,
    val course: CourseDto? = null,
    val id: Int? = null,
    val name: String? = null,
    val year: Int? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
