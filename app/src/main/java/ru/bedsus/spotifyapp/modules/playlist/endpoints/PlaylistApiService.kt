package ru.bedsus.spotifyapp.modules.playlist.endpoints

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistApi

interface PlaylistApiService {

    @GET("v1/users/$USER_ID/playlists")
    suspend fun getUserPlaylists(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): PlaylistApi

    companion object {
        // TODO Реализовать авторизацию и получать user id
        const val USER_ID = "kufx39qkor1zw189dl8xu5x60"
    }
}