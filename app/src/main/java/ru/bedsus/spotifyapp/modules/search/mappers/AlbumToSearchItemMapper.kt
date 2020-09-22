package ru.bedsus.spotifyapp.modules.search.mappers

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.modules.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.modules.search.models.SearchType
import ru.bedsus.spotifyapp.modules.search.models.SearchItem

object AlbumToSearchItemMapper : Mapper<SimpleAlbum, SearchItem> {
    override fun map(input: SimpleAlbum): SearchItem {
        input.apply {
            return SearchItem(
                    id = id,
                    firstText = name,
                    secondText = artists.joinToString(", ") { it.name },
                    image = image.url,
                    type = SearchType.ALBUM
            )
        }
    }
}