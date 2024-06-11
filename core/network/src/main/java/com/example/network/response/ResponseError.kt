package com.example.network.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseError(
    val code: String? = null,
    val link: String? = null,
    val data: String? = null,
    val detail: String? = null,
    val type: Int? = null,
    val resourceName: String? = null,
    val propertyName: String? = null,
    val attemptedValue: String? = null
)
