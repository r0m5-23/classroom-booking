package com.example.classroommanagement.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.classroommanagement.data.local.daos.BuildingDAO
import com.example.classroommanagement.data.local.daos.ClassroomDAO
import com.example.classroommanagement.data.local.entities.BuildingEntity
import com.example.classroommanagement.data.local.entities.ClassroomEntity

@Database(
    [BuildingEntity::class, ClassroomEntity::class],
    version = 1,
    exportSchema = true
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun classroomDAO(): ClassroomDAO
    abstract fun buildingDAO(): BuildingDAO
}