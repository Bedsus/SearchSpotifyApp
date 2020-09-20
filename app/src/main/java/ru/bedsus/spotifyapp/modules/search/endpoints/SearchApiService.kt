package ru.bedsus.spotifyapp.modules.search.endpoints

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {

    @GET("search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): ResponseBody
}