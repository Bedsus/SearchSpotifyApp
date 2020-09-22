package ru.bedsus.spotifyapp.modules.search.user_case

import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.modules.search.mappers.AlbumToSearchItemMapper
import ru.bedsus.spotifyapp.modules.search.mappers.ArtistToSearchItemMapper
import ru.bedsus.spotifyapp.modules.search.mappers.TrackToSearchItemMapper
import ru.bedsus.spotifyapp.modules.search.models.SearchItem
import ru.bedsus.spotifyapp.modules.search.models.SearchResult

object SearchUserCases {

    fun generateSearchQuery(
        query: String,
        fromYear: String?,
        toYear: String?,
        genre: String?,
    ): String {
        var resultQuery = query
        if (fromYear != null && toYear != null && fromYear.isNotEmpty() && toYear.isNotEmpty()) {
            resultQuery += " year:$fromYear-$toYear"
        } else if (fromYear != null && fromYear.isNotEmpty()) {
            resultQuery += " year:$fromYear"
        }
        if (genre != null && genre.isNotEmpty()) {
            resultQuery += " genre:$genre"
        }
        return resultQuery
    }

    fun createSearchItemList(result: SearchResult): List<SearchItem> {
        val searchItems = mutableListOf<SearchItem>()
        searchItems.addAll(ArtistToSearchItemMapper.listMap(result.artists))
        searchItems.addAll(TrackToSearchItemMapper.listMap(result.tracks))
        searchItems.addAll(AlbumToSearchItemMapper.listMap(result.albums))
        return searchItems
    }
}