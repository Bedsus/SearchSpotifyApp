package ru.bedsus.spotifyapp.modules.playlist.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.api.SpotifyApiService
import ru.bedsus.spotifyapp.data.playlist.mappers.PlaylistApiToPlaylistMapper
import ru.bedsus.spotifyapp.data.playlist.models.PlaylistItem
import ru.bedsus.spotifyapp.modules.followed.repository.FollowedRepository

class PlaylistRepositoryImpl(
    private val service: SpotifyApiService
) : PlaylistRepository {

    override suspend fun getUserPlaylists(): ResultRequest<List<PlaylistItem>> {
        return try {
            val playlistsApi = service.getUserPlaylists()
            val playlists = PlaylistApiToPlaylistMapper.listMap(playlistsApi.items) { it.id != null }
            ResultRequest.Success(playlists)
        } catch (ex: Exception) {
            ResultRequest.Error(ex)
        }
    }
}