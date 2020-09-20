package ru.bedsus.spotifyapp.modules.track

import ru.bedsus.spotifyapp.modules.search.models.SearchType
import ru.bedsus.spotifyapp.modules.artist.models.SimpleArtist

class SimpleTrack(
        val artists: List<SimpleArtist>,
        val id: String,
        val name: String,
        val type: SearchType,
        val uri: String,
)