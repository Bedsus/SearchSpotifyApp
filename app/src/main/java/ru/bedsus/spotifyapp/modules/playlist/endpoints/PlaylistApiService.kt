package ru.bedsus.spotifyapp.modules.playlist.endpoints

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistApi

interface PlaylistApiService {

    @GET("v1/users/$USER_ID/playlists")
    suspend fun getUserPlaylists(
        @Header("Authorization") token: String = TOKEN,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): PlaylistApi

    companion object {
        // TODO Реализовать авторизацию и получать user id
        const val USER_ID = "kufx39qkor1zw189dl8xu5x60"
        const val TOKEN = "Bearer BQBXZ3wcNJq0YYR3mZGpluUFcDUjjt1GcMQwz7Q_Q1PZlCGlQ1MfZ0ovoSprlUt2-CRuCdwDADjsGxCtlLpS2VxIqqiHiv-H7bqqyyAl8TSreCJl8WKjMh-XYdJuVkyx3iXVjPq2-7jA__7bsTuHF95NG4jHd-6qRUCDXs5J"
    }
}