package ru.bedsus.spotifyapp.data.search.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.data.album.models.AlbumApiModel
import ru.bedsus.spotifyapp.data.artist.models.ArtistApiModel
import ru.bedsus.spotifyapp.data.items.ItemsApiModel
import ru.bedsus.spotifyapp.data.track.models.TrackApiModel

class SearchResultApiModel (
    @SerializedName("albums") val albums: ItemsApiModel<AlbumApiModel>?,
    @SerializedName("artists") val artists: ItemsApiModel<ArtistApiModel>?,
    @SerializedName("tracks") val tracks: ItemsApiModel<TrackApiModel>?
)