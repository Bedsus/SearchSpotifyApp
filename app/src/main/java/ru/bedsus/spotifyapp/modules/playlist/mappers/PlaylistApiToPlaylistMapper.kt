package ru.bedsus.spotifyapp.modules.playlist.mappers

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.modules.image.mapper.getBigImage
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItemApi

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
}