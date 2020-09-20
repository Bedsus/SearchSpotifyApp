package ru.bedsus.spotifyapp.modules.album.models

import ru.bedsus.spotifyapp.modules.artist.models.SimpleArtist
import ru.bedsus.spotifyapp.modules.image.models.Image
import ru.bedsus.spotifyapp.modules.search.models.SearchType

class SimpleAlbum(
        val id: String,
        val name: String,
        val type: SearchType,
        val uri: String,
        val albumType: AlbumType,
        val artists: SimpleArtist,
        val images: List<Image>
)