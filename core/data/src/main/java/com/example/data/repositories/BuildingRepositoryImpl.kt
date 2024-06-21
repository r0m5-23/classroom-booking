package com.example.data.repositories

import com.example.data.remote.asBuildingEntity
import com.example.database.daos.BuildingDAO
import com.example.database.entities.BuildingEntity
import com.example.database.entities.BuildingWithClassroomsEntity
import com.example.database.entities.asBuilding
import com.example.database.entities.asBuildingWithClassrooms
import com.example.domain.models.Building
import com.example.domain.models.BuildingWithClassrooms
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