package ru.bedsus.spotifyapp.modules.playlist.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.bedsus.core.network.NetworkService
import ru.bedsus.spotifyapp.modules.playlist.endpoints.PlaylistApiService
import ru.bedsus.spotifyapp.modules.playlist.mappers.PlaylistApiToPlaylistMapper
import ru.bedsus.spotifyapp.modules.playlist.repository.PlaylistRepository
import ru.bedsus.spotifyapp.modules.playlist.repository.PlaylistRepositoryImpl
import ru.bedsus.spotifyapp.modules.playlist.vm.PlaylistViewModel

val playlistModule = module {
    single { getPlaylistApiService(get()) }
    single { PlaylistApiToPlaylistMapper() }
    single<PlaylistRepository> { PlaylistRepositoryImpl(get(), get()) }
    viewModel { PlaylistViewModel(get()) }
}

private fun getPlaylistApiService(service: NetworkService): PlaylistApiService {
    return service.create(PlaylistApiService::class.java)
}