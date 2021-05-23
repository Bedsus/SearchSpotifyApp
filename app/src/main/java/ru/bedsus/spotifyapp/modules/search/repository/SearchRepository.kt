package ru.bedsus.spotifyapp.modules.search.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.data.search.models.SearchResult

interface SearchRepository {

    suspend fun search(
        query: String,
        type: String,
        limit: Int? = null,
        offset: Int? = null
    ): ResultRequest<SearchResult>
}