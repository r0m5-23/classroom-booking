package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.daos.BuildingDAO
import com.example.database.daos.ClassroomDAO
import com.example.database.entities.BuildingEntity
import com.example.database.entities.ClassroomEntity

@Database(
    [BuildingEntity::class, ClassroomEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun classroomDAO(): ClassroomDAO
    abstract fun buildingDAO(): BuildingDAO
}