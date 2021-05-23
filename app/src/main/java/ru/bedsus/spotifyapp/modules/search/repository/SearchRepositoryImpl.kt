package ru.bedsus.spotifyapp.modules.search.repository

import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.api.SpotifyApiService
import ru.bedsus.spotifyapp.data.search.mappers.SearchResultApiToSearchResultMapper
import ru.bedsus.spotifyapp.data.search.models.SearchResult

class SearchRepositoryImpl(
    private val service: SpotifyApiService
) : SearchRepository {

    override suspend fun search(
        query: String,
        type: String,
        limit: Int?,
        offset: Int?
    ): ResultRequest<SearchResult> {
        return try {
            val searchApi = service.search(query, type, 2, 0)
            ResultRequest.Success(SearchResultApiToSearchResultMapper.map(searchApi))
        } catch (ex: Exception) {
            ResultRequest.Error(ex)
        }
    }
}