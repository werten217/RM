package com.ilya.rm.data.network

import com.ilya.rm.data.model.episode.Episode
import com.ilya.rm.data.model.episode.EpisodeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {
    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int = 1): EpisodeResponse

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): Episode
}