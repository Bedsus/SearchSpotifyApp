package ru.bedsus.spotifyapp.data.album.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.data.album.models.AlbumApiModel
import ru.bedsus.spotifyapp.data.album.models.AlbumType
import ru.bedsus.spotifyapp.data.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.data.artist.mapper.ArtistApiToArtistMapper
import ru.bedsus.spotifyapp.data.image.mapper.getBigImage

object AlbumApiToSimpleAlbumMapper : Mapper<AlbumApiModel, SimpleAlbum> {
    override fun map(input: AlbumApiModel): SimpleAlbum {
        input.apply {
            return SimpleAlbum(
                id = id ?: "",
                name = name ?: "",
                uri = uri ?: "",
                albumType = AlbumType.findTypeByValue(type ?: "") ?: AlbumType.ALBUM,
                artists = ArtistApiToArtistMapper.listMap(artists) { it.id != null },
                image = getBigImage(images)
            )
        }
    }
}