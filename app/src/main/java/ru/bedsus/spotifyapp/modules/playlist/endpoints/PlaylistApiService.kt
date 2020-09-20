package ru.bedsus.spotifyapp.modules.playlist.endpoints

import retrofit2.http.GET
import retrofit2.http.Query
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistApi

interface PlaylistApiService {

    @GET("me/playlists")
    suspend fun getUserPlaylists(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): PlaylistApi
}