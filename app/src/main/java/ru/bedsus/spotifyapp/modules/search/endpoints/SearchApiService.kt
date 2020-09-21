package ru.bedsus.spotifyapp.modules.search.endpoints

import retrofit2.http.GET
import retrofit2.http.Query
import ru.bedsus.spotifyapp.modules.search.models.SearchResultApi

interface SearchApiService {

    @GET("search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): SearchResultApi
}