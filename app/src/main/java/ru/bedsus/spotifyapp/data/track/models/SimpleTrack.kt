package ru.bedsus.spotifyapp.data.track.models

import ru.bedsus.spotifyapp.data.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.data.artist.models.ArtistItem

class SimpleTrack(
    val artists: List<ArtistItem>,
    val id: String,
    val name: String,
    val album: SimpleAlbum?,
    val uri: String,
)