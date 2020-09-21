package ru.bedsus.spotifyapp.modules.album.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.modules.album.models.AlbumApi
import ru.bedsus.spotifyapp.modules.album.models.AlbumType
import ru.bedsus.spotifyapp.modules.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.modules.artist.mapper.ArtistApiToArtistMapper
import ru.bedsus.spotifyapp.modules.image.mapper.getBigImage

object AlbumApiToSimpleAlbumMapper : Mapper<AlbumApi, SimpleAlbum> {
    override fun map(input: AlbumApi): SimpleAlbum {
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