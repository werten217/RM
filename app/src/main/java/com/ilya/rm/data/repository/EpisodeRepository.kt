package com.ilya.rm.data.repository

import com.ilya.rm.data.model.episode.Episode
import com.ilya.rm.data.model.episode.EpisodeResponse
import com.ilya.rm.data.network.EpisodeApiService

class EpisodeRepository(private val api: EpisodeApiService) {

    suspend fun getEpisodes(page: Int = 1): EpisodeResponse {
        return api.getEpisodes(page)
    }

    suspend fun getEpisodeById(id: Int): Episode {
        return api.getEpisodeById(id)
    }
}