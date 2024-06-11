package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class EventBookingTicketEventDto(
    val eventId: Int? = null,
    val eventBookingTicketId: Int? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
