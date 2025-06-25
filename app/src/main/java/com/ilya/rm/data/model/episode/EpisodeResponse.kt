package com.ilya.rm.data.model.episode

import com.ilya.rm.data.model.Info

data class EpisodeResponse(
    val info: Info,
    val results: List<Episode>
)
