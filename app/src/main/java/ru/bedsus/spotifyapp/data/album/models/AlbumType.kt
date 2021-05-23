package ru.bedsus.spotifyapp.data.album.models

enum class AlbumType(val value: String) {
    ALBUM("album"),
    SINGLE("single"),
    COMPILATION("compilation");

    companion object {
        fun findTypeByValue(value: String): AlbumType? {
            return values().find { value == it.value }
        }
    }
}