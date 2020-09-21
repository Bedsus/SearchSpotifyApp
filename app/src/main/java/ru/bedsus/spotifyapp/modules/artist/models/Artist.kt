package ru.bedsus.spotifyapp.modules.artist.models

import ru.bedsus.spotifyapp.modules.image.models.Image

class Artist(
        val href: String,
        val id: String,
        val name: String,
        val uri: String,
        val image: Image,
        val popularity: Int,
        val genres: List<String>
)