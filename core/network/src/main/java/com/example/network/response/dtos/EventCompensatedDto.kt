package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class EventCompensatedDto(
    val eventCompensationId: Int? = null,
    val eventId: Int? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
