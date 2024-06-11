package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class BC_UtilizadoresDto(
    val userId: Int? = null,
    val userLogin: String? = null,
    val password: String? = null,
    val name: String? = null,
    val hour: String? = null,
    val administrator: Boolean? = null,
    val activeAccount: Boolean? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
