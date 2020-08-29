package ru.bedsus.spotifyapp.modules.playlist.repository

import ru.bedsus.core.repository.NullableInputListMapperImpl
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.modules.playlist.endpoints.PlaylistApiService
import ru.bedsus.spotifyapp.modules.playlist.mappers.PlaylistApiToPlaylistMapper
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem
import timber.log.Timber

class PlaylistRepositoryImpl(
    private val mapper: PlaylistApiToPlaylistMapper,
    private val service: PlaylistApiService
) : PlaylistRepository {

    override suspend fun getUserPlaylists(): ResultRequest<List<PlaylistItem>> {
        return try {
            val playlistsApi = service.getUserPlaylists()
            val playlists = NullableInputListMapperImpl(mapper).map(playlistsApi.items ?: listOf())
            ResultRequest.Success(playlists)
        } catch (ex: Exception) {
            ResultRequest.Error(ex)
        }
    }
}