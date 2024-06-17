package com.example.classroombooking.di

import com.example.classroombooking.data.repositories.BuildingRepositoryImpl
import com.example.classroombooking.data.repositories.ClassroomRepositoryImpl
import com.example.classroombooking.domain.repositories.BuildingRepository
import com.example.classroombooking.domain.repositories.ClassroomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindClassroomRepository(
        classroomRepositoryImpl: ClassroomRepositoryImpl
    ): ClassroomRepository

    @Singleton
    @Binds
    abstract fun bindBuildingRepository(
        buildingRepositoryImpl: BuildingRepositoryImpl
    ): BuildingRepository
}