package ru.bedsus.spotifyapp.modules.search.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.modules.search.endpoints.SearchApiService
import ru.bedsus.spotifyapp.modules.search.mapper.SearchResultApiToSearchResultMapper
import ru.bedsus.spotifyapp.modules.search.models.SearchResult

class SearchRepositoryImpl(
    private val service: SearchApiService
) : SearchRepository {

    override suspend fun search(
        query: String,
        type: String,
        limit: Int?,
        offset: Int?
    ): ResultRequest<SearchResult> {
        return try {
            val searchApi = service.search(query, type, limit, offset)
            ResultRequest.Success(SearchResultApiToSearchResultMapper.map(searchApi))
        } catch (ex: Exception) {
            ResultRequest.Error(ex)
        }
    }
}