package ru.bedsus.spotifyapp.data.track.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.data.search.models.SearchType
import ru.bedsus.spotifyapp.data.search.models.ListItem
import ru.bedsus.spotifyapp.data.track.models.SimpleTrack

object TrackToListItemMapper : Mapper<SimpleTrack, ListItem> {
    override fun map(input: SimpleTrack): ListItem {
        input.apply {
            return ListItem(
                    id = id,
                    firstText = name,
                    secondText = artists.joinToString(", ") { it.name },
                    image = album?.image?.url ?: "",
                    type = SearchType.ALBUM
            )
        }
    }
}