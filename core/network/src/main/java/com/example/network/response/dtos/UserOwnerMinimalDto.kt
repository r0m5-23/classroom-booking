package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class UserOwnerMinimalDto(
    val id: String? = null,
    val userName: String? = null,
    val isAdmin: Boolean? = null,
    val email: String? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null,
)
