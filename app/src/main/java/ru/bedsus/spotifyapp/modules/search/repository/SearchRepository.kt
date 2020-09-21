package ru.bedsus.spotifyapp.modules.search.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.modules.search.models.SearchResult
import ru.bedsus.spotifyapp.modules.search.models.SearchType

interface SearchRepository {

    suspend fun search(
        query: String,
        type: String,
        limit: Int? = null,
        offset: Int? = null
    ): ResultRequest<SearchResult>
}