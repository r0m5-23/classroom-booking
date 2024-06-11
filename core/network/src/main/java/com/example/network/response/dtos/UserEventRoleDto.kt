package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class UserEventRoleDto(
    val eventUserRoleType: Int? = null, // Enum
    val user: UserMinimalDto? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
