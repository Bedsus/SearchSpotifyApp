package ru.bedsus.spotifyapp.data.artist.models

import ru.bedsus.spotifyapp.data.image.models.Image

class ArtistItem(
        val href: String,
        val id: String,
        val name: String,
        val uri: String,
        val image: Image,
        val popularity: Int,
        val genres: List<String>
)