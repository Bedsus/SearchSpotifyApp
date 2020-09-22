package ru.bedsus.spotifyapp.modules.search.vm.mappers

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.modules.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.modules.search.models.SearchType
import ru.bedsus.spotifyapp.modules.search.vm.models.SearchItem
import ru.bedsus.spotifyapp.modules.track.models.SimpleTrack

object TrackToSearchItemMapper : Mapper<SimpleTrack, SearchItem> {
    override fun map(input: SimpleTrack): SearchItem {
        input.apply {
            return SearchItem(
                    id = id,
                    firstText = name,
                    secondText = artists.joinToString(", "),
                    image = album?.image?.url ?: "",
                    type = SearchType.ALBUM
            )
        }
    }
}