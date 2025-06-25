package com.ilya.rm.data.model.location

import com.ilya.rm.data.model.Info

data class LocationResponse(
    val info: Info,
    val results: List<Location>
)
