package com.example.mapscompose.presentation

import com.example.mapscompose.domain.model.ParkingSpot
import com.google.android.gms.maps.model.LatLng

sealed class MapEvent {
    object ToggleEvent : MapEvent()
    data class OnMapLongClickEvent(val latLong: LatLng) : MapEvent()
    data class OnInfoWindowLongClickEvent(val spot: ParkingSpot) : MapEvent()
}
