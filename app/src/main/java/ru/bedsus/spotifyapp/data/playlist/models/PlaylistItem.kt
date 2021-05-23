package ru.bedsus.spotifyapp.data.playlist.models

import ru.bedsus.spotifyapp.data.image.models.Image

data class PlaylistItem(
    val id: String,
    val name: String,
    val image: Image?
)