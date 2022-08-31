package com.example.mapscompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapscompose.domain.ParkingSpotRepository
import com.example.mapscompose.domain.model.ParkingSpot
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: ParkingSpotRepository
) : ViewModel() {
    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            repository.getAllParkingSpot().collectLatest { list ->
                state = state.copy(
                    spots = list
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            MapEvent.ToggleEvent -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if (!state.isFalloutMap) MapStyleOptions(MapStyle.json) else null
                    ),
                    isFalloutMap = !state.isFalloutMap
                )
            }
            is MapEvent.OnInfoWindowLongClickEvent -> {
                viewModelScope.launch {
                    repository.deleteParkingSpot(event.spot)
                }
            }
            is MapEvent.OnMapLongClickEvent -> {
                viewModelScope.launch {
                    repository.insertParkingSpot(
                        ParkingSpot(
                            lat = event.latLong.latitude,
                            lng = event.latLong.longitude
                        )
                    )
                }
            }
        }
    }
}