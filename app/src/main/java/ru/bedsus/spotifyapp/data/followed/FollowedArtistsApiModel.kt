package ru.bedsus.spotifyapp.data.followed

import com.google.gson.annotations.SerializedName
import ru.bedsus.spotifyapp.data.artist.models.ArtistApiModel
import ru.bedsus.spotifyapp.data.items.ItemsApiModel

class FollowedArtistsApiModel(
    @SerializedName("artists") val artists: ItemsApiModel<ArtistApiModel>?,
)