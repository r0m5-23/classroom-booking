package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AcademicYearDto(
    val id: Int? = null,
    val name: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
