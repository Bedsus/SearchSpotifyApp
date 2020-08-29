package ru.bedsus.spotifyapp.modules.playlist.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.modules.playlist.repository.PlaylistRepository

class PlaylistViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlistLiveData = liveData {
        emit(ResultRequest.Loading)
        emit(repository.getUserPlaylists())
    }
}