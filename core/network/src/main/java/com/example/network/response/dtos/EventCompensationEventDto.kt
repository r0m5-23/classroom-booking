package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class EventCompensationEventDto(
    val eventCompensated: EventCompensatedDto? = null,
    val eventId: Int? = null,
    val id: Int? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
