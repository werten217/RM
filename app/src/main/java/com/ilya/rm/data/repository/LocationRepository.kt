package com.ilya.rm.data.repository

import com.ilya.rm.data.model.location.Location
import com.ilya.rm.data.model.location.LocationResponse
import com.ilya.rm.data.network.LocationApiService

class LocationRepository(private val api: LocationApiService) {

    suspend fun getLocations(page: Int = 1): LocationResponse {
        return api.getLocations(page)
    }

    suspend fun getLocationById(id: Int): Location {
        return api.getLocationById(id)
    }
}