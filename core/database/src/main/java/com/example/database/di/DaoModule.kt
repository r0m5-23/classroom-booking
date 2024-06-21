package com.example.database.di

import com.example.database.LocalDatabase
import com.example.database.daos.BuildingDAO
import com.example.database.daos.ClassroomDAO
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