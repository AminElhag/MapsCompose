package com.example.mapscompose.domain

import com.example.mapscompose.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {

    suspend fun insertParkingSpot(spot: ParkingSpot)

    suspend fun deleteParkingSpot(spot: ParkingSpot)

    fun getAllParkingSpot(): Flow<List<ParkingSpot>>
}