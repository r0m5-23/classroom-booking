package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class TeacherDto(
    val id: Int? = null,
    val name: String? = null,
    val acronym: String? = null,
    val code: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val observations: String? = null,
    val consecutiveLimit: Int? = null,
    val constFreeDays: Boolean? = null,
    val dayLimit: Int? = null,
    val freeDays: Int? = null,
    val degreeImportance: Int? = null,
    val category: CategoryDto? = null,
    val labourContract: LabourContractDto? = null,
    val scientificArea: ScientificAreaDto? = null,
    val active: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
