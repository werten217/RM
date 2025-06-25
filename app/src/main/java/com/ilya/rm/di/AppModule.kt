package com.ilya.rm.di

import com.ilya.rm.data.network.CharacterApiService
import com.ilya.rm.data.network.EpisodeApiService
import com.ilya.rm.data.network.LocationApiService
import com.ilya.rm.data.repository.CharacterRepository
import com.ilya.rm.data.repository.EpisodeRepository
import com.ilya.rm.data.repository.LocationRepository
import com.ilya.rm.ui.characters.CharacterViewModel
import com.ilya.rm.ui.episodes.EpisodeViewModel
import com.ilya.rm.ui.locations.LocationViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"

val networkModule = module {
    single {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<CharacterApiService> { get<Retrofit>().create(CharacterApiService::class.java) }
    single<LocationApiService> { get<Retrofit>().create(LocationApiService::class.java) }
    single<EpisodeApiService> { get<Retrofit>().create(EpisodeApiService::class.java) }
}

val repositoryModule = module {
    single { CharacterRepository(get()) }
    single { LocationRepository(get()) }
    single { EpisodeRepository(get()) }
}

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
}

val appModule = listOf(networkModule, repositoryModule, viewModelModule)