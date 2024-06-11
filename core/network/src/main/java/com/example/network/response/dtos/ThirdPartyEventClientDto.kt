package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ThirdPartyEventClientDto(
    val eventId: Int? = null,
    val clientId: String? = null,
    val stillThirdParty: Boolean? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
)
