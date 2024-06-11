package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class EventUserLockedDto(
    val eventId: Int? = null,
    val user: BC_UtilizadoresDto? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
