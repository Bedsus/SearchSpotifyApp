package ru.bedsus.spotifyapp.modules.track.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.modules.album.models.AlbumApi
import ru.bedsus.spotifyapp.modules.artist.models.ArtistApi

class TrackApi(
        @SerializedName("artists") val artists: List<ArtistApi>?,
        @SerializedName("album") val album: AlbumApi?,
        @SerializedName("href") val href: String?,
        @SerializedName("id") val id: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("uri") val uri: String?,
        @SerializedName("popularity") val popularity: Int?,
)