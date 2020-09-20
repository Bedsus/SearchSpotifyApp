package ru.bedsus.spotifyapp.modules.album.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.modules.image.models.ImageApi
import ru.bedsus.spotifyapp.modules.track.TrackApi
import ru.bedsus.spotifyapp.modules.artist.models.ArtistApi

class AlbumApi(
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("images") val images: List<ImageApi>?,
        @SerializedName("name") val name: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?,
        @SerializedName("popularity") val popularity: Int?,
        @SerializedName("genres") val genres: List<String>?,
        @SerializedName("tracks") val tracks: List<TrackApi>?,
        @SerializedName("release_date") val releaseDate: String?,
        @SerializedName("release_date_precision") val releaseDatePrecision: String?,
        @SerializedName("label") val label: String?,
        @SerializedName("album_type") val albumType: String?,
        @SerializedName("artists") val artists: List<ArtistApi>?,
)