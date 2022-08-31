package com.example.mapscompose.presentation

import com.example.mapscompose.domain.model.ParkingSpot
import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isFalloutMap: Boolean = false,
    val spots: List<ParkingSpot> = emptyList()
)