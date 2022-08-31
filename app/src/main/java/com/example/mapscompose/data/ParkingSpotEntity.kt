package com.example.mapscompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mapscompose.domain.model.ParkingSpot

@Entity
data class ParkingSpotEntity(
    var lat: Double,
    var lng: Double,
    @PrimaryKey
    var id: Int? = null
)

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot {
    return ParkingSpot(
        lat = lat,
        lng = lng,
        id = id
    )
}