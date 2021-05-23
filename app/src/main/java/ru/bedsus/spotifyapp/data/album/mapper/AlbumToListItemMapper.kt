package ru.bedsus.spotifyapp.data.album.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.data.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.data.search.models.SearchType
import ru.bedsus.spotifyapp.data.search.models.ListItem

object AlbumToListItemMapper : Mapper<SimpleAlbum, ListItem> {
    override fun map(input: SimpleAlbum): ListItem {
        input.apply {
            return ListItem(
                    id = id,
                    firstText = name,
                    secondText = artists.joinToString(", ") { it.name },
                    image = image.url,
                    type = SearchType.ALBUM
            )
        }
    }
}