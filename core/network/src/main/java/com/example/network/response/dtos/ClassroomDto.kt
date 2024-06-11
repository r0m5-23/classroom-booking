package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ClassroomDto(
    val id: Int? = null,
    val name: String? = null,
    val code: String? = null,
    val capacity: Int? = null,
    val capacityExam: Int? = null,
    val capacityMargin: Int? = null,
    val observations: String? = null,
    val email: String? = null,
    val belongsToMyGroups: Boolean? = null,
    val canCreateAnEvent: Boolean? = null,
    val canRequestAnEvent: Boolean? = null,
    val isMyFavorite: Boolean? = null,
    val classroomGroups: List<ClassroomGroupMinimalDto>? = emptyList(),
    val classroomGroupsBookings: List<ClassroomGroupBookingMinimalDto>? = emptyList(),
    val building: BuildingDto? = null,
    val floor: FloorDto? = null,
    val characteristics: List<CharacteristicDto>? = emptyList(),
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
