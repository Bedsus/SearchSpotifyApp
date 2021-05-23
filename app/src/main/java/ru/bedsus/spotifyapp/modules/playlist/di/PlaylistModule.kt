package ru.bedsus.spotifyapp.modules.playlist.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.bedsus.spotifyapp.modules.playlist.repository.PlaylistRepository
import ru.bedsus.spotifyapp.modules.playlist.repository.PlaylistRepositoryImpl
import ru.bedsus.spotifyapp.modules.playlist.vm.PlaylistViewModel

val playlistModule = module {
    single<PlaylistRepository> { PlaylistRepositoryImpl(get()) }
    viewModel { PlaylistViewModel(get()) }
}