package com.example.network.response

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<T>(
    val data: T,
    val errors: List<ResponseError>? = emptyList(),
    val message: String
)
