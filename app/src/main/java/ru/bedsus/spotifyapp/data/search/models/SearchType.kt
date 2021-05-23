package ru.bedsus.spotifyapp.data.search.models

/**
 * Группы для поиска (альбомы, артисты и треки)
 */
enum class SearchType(val value: String) {
   ALBUM("album"),
   ARTIST("artist"),
   TRACK("track")
}