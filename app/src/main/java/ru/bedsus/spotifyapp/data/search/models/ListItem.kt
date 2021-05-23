package ru.bedsus.spotifyapp.data.search.models

data class ListItem(
        val id: String,
        val firstText: String,
        val secondText: String?,
        val image: String,
        val type: SearchType
)