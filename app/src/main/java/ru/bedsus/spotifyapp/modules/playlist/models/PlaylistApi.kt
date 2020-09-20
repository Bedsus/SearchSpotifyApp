package ru.bedsus.spotifyapp.modules.playlist.models

import com.google.gson.annotations.SerializedName

class PlaylistApi(
    @SerializedName("items") val items: List<PlaylistItemApi>?
)