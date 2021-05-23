package ru.bedsus.spotifyapp.modules.followed.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.api.SpotifyApiService
import ru.bedsus.spotifyapp.data.artist.mapper.ArtistApiToArtistMapper
import ru.bedsus.spotifyapp.data.artist.models.ArtistItem

class FollowedRepositoryImpl(
    private val service: SpotifyApiService
) : FollowedRepository {

    override suspend fun getFollowedArtists(): ResultRequest<List<ArtistItem>> {
        return try {
            val followedArtistsApiModel = service.getFollowedArtists("artist")
            val playlists = ArtistApiToArtistMapper.listMap(followedArtistsApiModel.artists?.items) { it.id != null }
            ResultRequest.Success(playlists)
        } catch (ex: Exception) {
            ResultRequest.Error(ex)
        }
    }
}