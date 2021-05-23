package ru.bedsus.spotifyapp.data.album.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.data.image.models.ImageApiModel
import ru.bedsus.spotifyapp.data.track.models.TrackApiModel
import ru.bedsus.spotifyapp.data.artist.models.ArtistApiModel

class AlbumApiModel(
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("images") val images: List<ImageApiModel>?,
        @SerializedName("name") val name: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?,
        @SerializedName("popularity") val popularity: Int?,
        @SerializedName("genres") val genres: List<String>?,
        @SerializedName("tracks") val tracks: List<TrackApiModel>?,
        @SerializedName("release_date") val releaseDate: String?,
        @SerializedName("release_date_precision") val releaseDatePrecision: String?,
        @SerializedName("label") val label: String?,
        @SerializedName("album_type") val albumType: String?,
        @SerializedName("artists") val artists: List<ArtistApiModel>?,
)