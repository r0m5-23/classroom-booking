package com.example.classroommanagement.di

import com.example.network.repository.RemoteDataSourceRepository
import com.example.network.repository.RemoteDataSourceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSourceRepository(remoteDataSourceRepositoryImpl: RemoteDataSourceRepositoryImpl): RemoteDataSourceRepository


}