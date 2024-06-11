package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ClassroomGroupBookingMinimalDto(
    val id: Int? = null,
    val name: String? = null,
    val canCreateAnEvent: Boolean? = null,
    val canRequestAnEvent: Boolean? = null,
    val annotation: String? = null,
    val maxRequestedEventDuration: Int? = null,
    val upperRequestedEventLimit: Int? = null,
    val lowerRequestedEventLimit: Int? = null,
    val usersOwners: List<UserOwnerMinimalDto>? = emptyList(),
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)