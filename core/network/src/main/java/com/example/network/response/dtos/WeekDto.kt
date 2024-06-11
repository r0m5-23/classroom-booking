package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class WeekDto(
    val id: Int? = null,
    val startDate: String? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
