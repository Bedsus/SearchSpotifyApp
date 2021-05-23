package ru.bedsus.spotifyapp.data.playlist.mappers

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.data.image.mapper.getBigImage
import ru.bedsus.spotifyapp.data.playlist.models.PlaylistItem
import ru.bedsus.spotifyapp.data.playlist.models.PlaylistItemApiModel

object PlaylistApiToPlaylistMapper : Mapper<PlaylistItemApiModel, PlaylistItem> {
    override fun map(input: PlaylistItemApiModel): PlaylistItem {
        with(input) {
            return PlaylistItem(
                id = id ?: "",
                name = name ?: "",
                image = getBigImage(images)
            )
        }
    }
}