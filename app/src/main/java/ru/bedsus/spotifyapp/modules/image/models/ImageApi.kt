package ru.bedsus.spotifyapp.modules.image.models

import com.google.gson.annotations.SerializedName


class ImageApi(
        @SerializedName("url") val url: String?,
        @SerializedName("height") val height: Int?,
        @SerializedName("width") val width: Int?
)