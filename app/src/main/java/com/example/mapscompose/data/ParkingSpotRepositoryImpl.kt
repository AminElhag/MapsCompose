package com.example.mapscompose.data

import com.example.mapscompose.domain.ParkingSpotRepository
import com.example.mapscompose.domain.model.ParkingSpot
import com.example.mapscompose.domain.model.toParkingSpotEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParkingSpotRepositoryImpl(
    private val dao: ParkingSpotDao
) : ParkingSpotRepository {

    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        dao.insertParkingSpot(spot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        dao.deleteParkingSpot(spot.toParkingSpotEntity())
    }

    override fun getAllParkingSpot(): Flow<List<ParkingSpot>> {
        return dao.getAllParkingSpot().map { list -> list.map { it.toParkingSpot() } }
    }
}