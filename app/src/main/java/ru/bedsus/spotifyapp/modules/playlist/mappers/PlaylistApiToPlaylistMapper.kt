package ru.bedsus.spotifyapp.modules.playlist.mappers

import ru.bedsus.spotifyapp.modules.playlist.models.Image
import ru.bedsus.spotifyapp.modules.playlist.models.ImageApi
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItemApi
import ru.bedsus.core.repository.Mapper
import java.lang.IllegalStateException

class PlaylistApiToPlaylistMapper : Mapper<PlaylistItemApi, PlaylistItem> {
    override fun map(input: PlaylistItemApi): PlaylistItem {
        with(input) {
            return PlaylistItem(
                id = id ?: "",
                name = name ?: "",
                image = getBigImage(images)
            )
        }
    }

    private fun getBigImage(list: List<ImageApi>?): Image? {
        return list?.map { Image(
                url = it.url ?: "",
                height = it.height ?: 0,
                width = it.width ?: 0
            )
        }?.maxByOrNull { it.height }
    }
}