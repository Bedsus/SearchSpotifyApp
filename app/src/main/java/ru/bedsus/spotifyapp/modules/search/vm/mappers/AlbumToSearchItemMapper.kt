package ru.bedsus.spotifyapp.modules.search.vm.mappers

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.modules.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.modules.search.models.SearchType
import ru.bedsus.spotifyapp.modules.search.vm.models.SearchItem

object AlbumToSearchItemMapper : Mapper<SimpleAlbum, SearchItem> {
    override fun map(input: SimpleAlbum): SearchItem {
        input.apply {
            return SearchItem(
                    id = id,
                    firstText = name,
                    secondText = artists.joinToString(", "),
                    image = image.url,
                    type = SearchType.ALBUM
            )
        }
    }
}