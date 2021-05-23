package ru.bedsus.spotifyapp.data.playlist.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.data.image.models.ImageApiModel

class PlaylistItemApiModel(
    @SerializedName("id") val id: String?,
    @SerializedName("images") val images: List<ImageApiModel>?,
    @SerializedName("name") val name: String?
)