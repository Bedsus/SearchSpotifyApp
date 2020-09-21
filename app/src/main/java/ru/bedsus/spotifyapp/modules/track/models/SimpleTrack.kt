package ru.bedsus.spotifyapp.modules.track.models

import ru.bedsus.spotifyapp.modules.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.modules.search.models.SearchType
import ru.bedsus.spotifyapp.modules.artist.models.Artist

class SimpleTrack(
    val artists: List<Artist>,
    val id: String,
    val name: String,
    val album: SimpleAlbum?,
    val uri: String,
)