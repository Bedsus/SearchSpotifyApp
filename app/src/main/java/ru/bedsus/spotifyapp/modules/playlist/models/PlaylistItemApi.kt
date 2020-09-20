package ru.bedsus.spotifyapp.modules.playlist.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.modules.image.models.ImageApi

class PlaylistItemApi(
        @SerializedName("id") val id: String?,
        @SerializedName("images") val images: List<ImageApi>?,
        @SerializedName("name") val name: String?
)