package ru.bedsus.spotifyapp.di

import org.koin.dsl.module
import ru.bedsus.core.network.NetworkService
import ru.bedsus.spotifyapp.api.SpotifyApiService

val appModule = module {
    single { getApiService(get()) }
}

private fun getApiService(service: NetworkService): SpotifyApiService {
    return service.create(SpotifyApiService::class.java)
}