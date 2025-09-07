package com.example.network.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestWithAuth = addAuthorization(request)
        val response = chain.proceed(requestWithAuth)
        return response
    }

    private fun addAuthorization(request: Request): Request {

        return request.newBuilder()
            .addHeader(
                "Authorization",
                "Bearer XXXXXXX"
            )
            .build()
    }
}

