package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class TypologyDto(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val color: String? = null,
    val constAvoidPeriodTypology: Boolean? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
