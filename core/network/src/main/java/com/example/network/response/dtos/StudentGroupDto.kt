package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class StudentGroupDto(
    val id: Int? = null,
    val name: String? = null,
    val observations: String? = null,
    val numStudents: Int? = null,
    val dayLimit: Int? = null,
    val consecutiveLimit: Int? = null,
    val code: String? = null,
    val curricularPlan: CurricularPlanDto? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
