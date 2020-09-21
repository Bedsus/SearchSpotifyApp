package ru.bedsus.spotifyapp.modules.search.models

import ru.bedsus.spotifyapp.modules.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.modules.artist.models.Artist
import ru.bedsus.spotifyapp.modules.track.models.SimpleTrack

class SearchResult (
    val artists: List<Artist>,
    val albums: List<SimpleAlbum>,
    val tracks: List<SimpleTrack>
)