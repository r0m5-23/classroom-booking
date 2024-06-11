package com.example.classroommanagement.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.classroommanagement.database.daos.BuildingDAO
import com.example.classroommanagement.database.daos.ClassroomDAO
import com.example.classroommanagement.database.entities.BuildingEntity
import com.example.classroommanagement.database.entities.ClassroomEntity

@Database(
    [BuildingEntity::class, ClassroomEntity::class],
    version = 1,
    exportSchema = true
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun classroomDAO(): ClassroomDAO
    abstract fun buildingDAO(): BuildingDAO
}