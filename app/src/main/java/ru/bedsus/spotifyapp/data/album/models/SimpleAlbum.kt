package ru.bedsus.spotifyapp.data.album.models

import ru.bedsus.spotifyapp.data.artist.models.ArtistItem
import ru.bedsus.spotifyapp.data.image.models.Image

class SimpleAlbum(
    val id: String,
    val name: String,
    val uri: String,
    val albumType: AlbumType,
    val artists: List<ArtistItem>,
    val image: Image
)