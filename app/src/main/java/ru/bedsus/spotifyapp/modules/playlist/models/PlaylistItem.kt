package ru.bedsus.spotifyapp.modules.playlist.models

import ru.bedsus.spotifyapp.modules.image.models.Image

data class PlaylistItem(
    val id: String,
    val name: String,
    val image: Image?
)