package com.example.classroommanagement.di

import com.example.classroommanagement.data.local.LocalDatabase
import com.example.classroommanagement.data.local.daos.BuildingDAO
import com.example.classroommanagement.data.local.daos.ClassroomDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideClassroomDao(
        database: LocalDatabase
    ): ClassroomDAO {
        return database.classroomDAO()
    }
    @Provides
    @Singleton
    fun provideBuildingDao(
        database: LocalDatabase
    ): BuildingDAO {
        return database.buildingDAO()
    }
}