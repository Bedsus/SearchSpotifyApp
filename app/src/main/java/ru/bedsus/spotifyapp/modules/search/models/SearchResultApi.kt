package ru.bedsus.spotifyapp.modules.search.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.modules.album.models.AlbumApi
import ru.bedsus.spotifyapp.modules.artist.models.ArtistApi
import ru.bedsus.spotifyapp.modules.track.models.TrackApi

class SearchResultApi (
    @SerializedName("artists") val artists: List<ArtistApi>,
    @SerializedName("albums") val albums: List<AlbumApi>,
    @SerializedName("tracks") val tracks: List<TrackApi>
)