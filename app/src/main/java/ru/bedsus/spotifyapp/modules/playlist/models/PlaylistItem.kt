package ru.bedsus.spotifyapp.modules.playlist.models

data class PlaylistItem(
    val id: String,
    val name: String,
    val image: Image?
)

class Image(
    val url: String,
    val height: Int,
    val width: Int,
)