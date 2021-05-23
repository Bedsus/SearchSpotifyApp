package ru.bedsus.spotifyapp.data.artist.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.data.artist.models.ArtistItem
import ru.bedsus.spotifyapp.data.search.models.SearchType
import ru.bedsus.spotifyapp.data.search.models.ListItem

object ArtistToListItemMapper : Mapper<ArtistItem, ListItem> {
    override fun map(input: ArtistItem): ListItem {
        input.apply {
            return ListItem(
                    id = id,
                    firstText = name,
                    secondText = null,
                    image = image.url,
                    type = SearchType.ARTIST
            )
        }
    }
}