package ru.bedsus.spotifyapp.modules.search.models

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.modules.album.models.AlbumApi
import ru.bedsus.spotifyapp.modules.artist.models.ArtistApi
import ru.bedsus.spotifyapp.modules.track.models.TrackApi

class SearchResultApi (
        @SerializedName("albums") val albums: AlbumItemsApi?,
        @SerializedName("artists") val artists: ArtistItemsApi?,
        @SerializedName("tracks") val tracks: TrackItemsApi?
) {
    class AlbumItemsApi(
        @SerializedName("items") val items: List<AlbumApi>,
    )

    class ArtistItemsApi(
        @SerializedName("items") val items: List<ArtistApi>,
    )

    class TrackItemsApi(
        @SerializedName("items") val items: List<TrackApi>,
    )
}