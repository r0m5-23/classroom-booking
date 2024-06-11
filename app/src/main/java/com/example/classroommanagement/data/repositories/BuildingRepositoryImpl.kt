package com.example.classroommanagement.data.repositories

import com.example.classroommanagement.data.local.daos.BuildingDAO
import com.example.classroommanagement.data.local.entities.BuildingEntity
import com.example.classroommanagement.data.local.entities.BuildingWithClassroomsEntity
import com.example.classroommanagement.data.local.entities.asBuilding
import com.example.classroommanagement.data.local.entities.asBuildingWithClassrooms
import com.example.classroommanagement.data.remote.asBuildingEntity
import com.example.classroommanagement.domain.models.Building
import com.example.classroommanagement.domain.models.BuildingWithClassrooms
import com.example.classroommanagement.domain.repositories.BuildingRepository
import com.example.network.repository.RemoteDataSourceRepository
import com.example.network.response.dtos.BuildingDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BuildingRepositoryImpl @Inject constructor(
    private val buildingDAO: BuildingDAO,
    private val network: RemoteDataSourceRepository
) : BuildingRepository {
    override suspend fun upsertBuildings(buildings: List<Building>) {
        // TODO() Synchronizer
        val networkBuildings = network.getBuildings()
        return buildingDAO.upsertBuildings(networkBuildings.map(BuildingDto::asBuildingEntity))
    }

    override fun getBuildingById(id: Int): Flow<Building> {
        return buildingDAO.getBuildingById(id).map { it.asBuilding() }
    }

    override fun getBuildings(): Flow<List<Building>> {
        return buildingDAO.getBuildings().map { it.map(BuildingEntity::asBuilding) }
    }

    override fun getBuildingsWithClassrooms(): Flow<List<BuildingWithClassrooms>> {
        return buildingDAO.getBuildingsWithRooms().map { it.map(BuildingWithClassroomsEntity::asBuildingWithClassrooms) }
    }
}