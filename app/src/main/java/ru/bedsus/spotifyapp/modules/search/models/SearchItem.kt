package ru.bedsus.spotifyapp.modules.search.models

data class SearchItem(
        val id: String,
        val firstText: String,
        val secondText: String?,
        val image: String,
        val type: SearchType
)