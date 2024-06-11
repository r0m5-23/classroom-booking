package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CourseDto(
    val id: Int? = null,
    val name: String? = null,
    val code: String? = null,
    val acronym: String? = null,
    val color: String? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
