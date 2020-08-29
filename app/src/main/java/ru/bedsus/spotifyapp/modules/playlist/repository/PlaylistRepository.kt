package ru.bedsus.spotifyapp.modules.playlist.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem

interface PlaylistRepository {

    suspend fun getUserPlaylists(): ResultRequest<List<PlaylistItem>>
}