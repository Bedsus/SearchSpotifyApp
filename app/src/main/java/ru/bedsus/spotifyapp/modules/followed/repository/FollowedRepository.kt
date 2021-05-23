package ru.bedsus.spotifyapp.modules.followed.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.data.artist.models.ArtistItem

interface FollowedRepository {

    suspend fun getFollowedArtists(): ResultRequest<List<ArtistItem>>
}