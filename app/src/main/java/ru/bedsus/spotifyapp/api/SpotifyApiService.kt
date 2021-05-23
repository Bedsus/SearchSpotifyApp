package ru.bedsus.spotifyapp.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.bedsus.spotifyapp.data.followed.FollowedArtistsApiModel
import ru.bedsus.spotifyapp.data.items.ItemsApiModel
import ru.bedsus.spotifyapp.data.playlist.models.PlaylistItemApiModel
import ru.bedsus.spotifyapp.data.search.models.SearchResultApiModel

interface SpotifyApiService {

    @GET("search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): SearchResultApiModel

    @GET("me/playlists")
    suspend fun getUserPlaylists(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): ItemsApiModel<PlaylistItemApiModel>

    @GET("me/following")
    suspend fun getFollowedArtists(
        @Query("type") type: String? = null,
        @Query("limit") limit: Int? = null
    ): FollowedArtistsApiModel
}