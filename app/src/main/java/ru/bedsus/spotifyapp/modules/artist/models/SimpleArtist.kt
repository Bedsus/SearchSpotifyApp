package ru.bedsus.spotifyapp.modules.artist.models

import ru.bedsus.spotifyapp.modules.search.models.SearchType

class SimpleArtist(
        val id: String,
        val name: String,
        val type: SearchType,
        val uri: String,
)