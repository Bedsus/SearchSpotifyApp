package ru.bedsus.spotifyapp.modules.playlist.models

import com.google.gson.annotations.SerializedName

class PlaylistApi(
    @SerializedName("items") val items: List<PlaylistItemApi>?
)

class PlaylistItemApi(
    @SerializedName("id") val id: String?,
    @SerializedName("images") val images: List<ImageApi>?,
    @SerializedName("name") val name: String?
)

class ImageApi(
    @SerializedName("url") val url: String?,
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?
)