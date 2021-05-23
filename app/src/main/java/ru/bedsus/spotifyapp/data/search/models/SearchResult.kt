package ru.bedsus.spotifyapp.data.search.models

import ru.bedsus.spotifyapp.data.album.models.SimpleAlbum
import ru.bedsus.spotifyapp.data.artist.models.ArtistItem
import ru.bedsus.spotifyapp.data.track.models.SimpleTrack

class SearchResult (
    val artists: List<ArtistItem>,
    val albums: List<SimpleAlbum>,
    val tracks: List<SimpleTrack>
)