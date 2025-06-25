package com.ilya.rm.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.rm.data.model.location.Location
import com.ilya.rm.data.repository.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationViewModel(private val repository: LocationRepository) : ViewModel() {

    private val _locations = MutableStateFlow<List<Location>>(emptyList())
    val locations: StateFlow<List<Location>> = _locations

    private val _selectedLocation = MutableStateFlow<Location?>(null)
    val selectedLocation: StateFlow<Location?> = _selectedLocation

    fun loadLocations() {
        viewModelScope.launch {
            try {
                val response = repository.getLocations()
                _locations.value = response.results
            } catch (e: Exception) {
            }
        }
    }

    fun loadLocationById(id: Int) {
        viewModelScope.launch {
            try {
                _selectedLocation.value = repository.getLocationById(id)
            } catch (e: Exception) {
            }
        }
    }
}