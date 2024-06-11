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
                "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjM4OThBOUUzRTNCNERGNDYxNTNFNkNBOEU4QjIwNTJEIiwidHlwIjoiYXQrand0In0.eyJuYmYiOjE3MTgxMjQ3NjEsImV4cCI6MTcxODEyODM2MSwiaXNzIjoiaHR0cHM6Ly9idWxsZXQtaXMudXRhZC5wdCIsImF1ZCI6ImJlc3RsZWdhY3lfYXBpX3Jlc291cmNlIiwiY2xpZW50X2lkIjoiYmVzdGxlZ2FjeV9hcGlfc3dhZ2dlciIsInN1YiI6IjAxZGFlNTBkLTY2MjktNGVlNS1iYWQ1LTE3MjAwNGM5YmViMyIsImF1dGhfdGltZSI6MTcxODEyNDc0NCwiaWRwIjoibG9jYWwiLCJyZWFkdXNlcnMiOiJyZWFkdXNlcnMiLCJuYW1lIjoianBtb3VyYUB1dGFkLnB0IiwiZW1haWwiOiJqcG1vdXJhQHV0YWQucHQiLCJzaWQiOiJFN0ZFMDY1MEVENjNBN0RFM0EyQTZGNzEyQTUzOENBRiIsImlhdCI6MTcxODEyNDc2MSwic2NvcGUiOlsiYmVzdGxlZ2FjeV9hcGlfc2NvcGUiXSwiYW1yIjpbInB3ZCJdfQ.DMWJ1wLNBKecc8DJ2mxiDG-4_EcTyka1FTs7z7nT6wiMUnQV0RygueVk5ECobKSlLDcgQ0fk4l9-fX8sqR2SYPQMGKcAHYhQvSfMQZrD1O0KQeAmKvazzeSlXW4M1ciL2_mUTFRqCg6vvnD1dFDW6hAek0GKhPMkb3ayNkeyHbqs9Cl85jG0KONDuFzUq-hsGAVfahqnV64-DZi5KbWnhzCewBuhL7wez2In4UQ0rayl8dvisZClvcNFh-2P97Q2B5DdaYocHANxxbL9xHWX-4Q-VU-3ca3rh1jILRvHZAs19Czd6XeOK6Mnp-FXYPckFFTue02x5c9aqRr-kBxenw"
            )
            .build()
    }
}

