package com.example.network.di

import com.example.network.api.AuthInterceptor
import com.example.network.api.BulletApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiServices(
        networkJson: Json,
        okHttpClient: OkHttpClient
    ): BulletApiServices {

        return Retrofit.Builder()
            .baseUrl("https://bullet-api.utad.pt/")
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
            .create(BulletApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkJson(): Json {
        return Json { ignoreUnknownKeys = true }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(
                HttpLoggingInterceptor(
                    HttpLoggingInterceptor.Logger { message ->
                        println("LOG-APP: $message")
                    }
                ).setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .addNetworkInterceptor(
                HttpLoggingInterceptor(
                    HttpLoggingInterceptor.Logger { message ->
                        println("LOG-NET: $message")
                    }
                ).setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }
}