package ru.bedsus.spotifyapp.modules.playlist.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.modules.playlist.endpoints.PlaylistApiService
import ru.bedsus.spotifyapp.modules.playlist.mappers.PlaylistApiToPlaylistMapper
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem

class PlaylistRepositoryImpl(
    private val mapper: PlaylistApiToPlaylistMapper,
    private val service: PlaylistApiService
) : PlaylistRepository {

    override suspend fun getUserPlaylists(): ResultRequest<List<PlaylistItem>> {
        return try {
            val playlistsApi = service.getUserPlaylists()
            val playlists = mapper.listMap(playlistsApi.items) { it.id != null }
            ResultRequest.Success(playlists)
        } catch (ex: Exception) {
            ResultRequest.Error(ex)
        }
    }
}