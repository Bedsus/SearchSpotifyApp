package ru.bedsus.spotifyapp.data.image.models

import com.google.gson.annotations.SerializedName


class ImageApiModel(
        @SerializedName("url") val url: String?,
        @SerializedName("height") val height: Int?,
        @SerializedName("width") val width: Int?
)