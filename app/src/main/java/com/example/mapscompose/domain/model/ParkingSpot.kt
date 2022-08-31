package com.example.mapscompose.domain.model

import com.example.mapscompose.data.ParkingSpotEntity

data class ParkingSpot(
    var lat: Double,
    var lng: Double,
    var id: Int? = null
)

fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}