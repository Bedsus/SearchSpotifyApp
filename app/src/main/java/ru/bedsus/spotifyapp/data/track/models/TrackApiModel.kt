package ru.bedsus.spotifyapp.data.track.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.data.album.models.AlbumApiModel
import ru.bedsus.spotifyapp.data.artist.models.ArtistApiModel

class TrackApiModel(
        @SerializedName("artists") val artists: List<ArtistApiModel>?,
        @SerializedName("album") val album: AlbumApiModel?,
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?,
        @SerializedName("popularity") val popularity: Int?,
)