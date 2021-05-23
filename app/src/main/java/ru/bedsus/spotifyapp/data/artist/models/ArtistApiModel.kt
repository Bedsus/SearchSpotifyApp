package ru.bedsus.spotifyapp.data.artist.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.data.image.models.ImageApiModel

class ArtistApiModel (
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("images") val images: List<ImageApiModel>?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?,
        @SerializedName("popularity") val popularity: Int?,
        @SerializedName("genres") val genres: List<String>?,
)