package ru.bedsus.spotifyapp.modules.search.user_case

import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.data.album.mapper.AlbumToListItemMapper
import ru.bedsus.spotifyapp.data.artist.mapper.ArtistToListItemMapper
import ru.bedsus.spotifyapp.data.track.mapper.TrackToListItemMapper
import ru.bedsus.spotifyapp.data.search.models.ListItem
import ru.bedsus.spotifyapp.data.search.models.SearchResult

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

    fun createSearchItemList(result: SearchResult): List<ListItem> {
        val searchItems = mutableListOf<ListItem>()
        searchItems.addAll(ArtistToListItemMapper.listMap(result.artists))
        searchItems.addAll(TrackToListItemMapper.listMap(result.tracks))
        searchItems.addAll(AlbumToListItemMapper.listMap(result.albums))
        return searchItems
    }
}