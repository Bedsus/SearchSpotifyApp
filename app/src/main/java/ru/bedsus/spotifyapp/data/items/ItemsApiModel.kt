package ru.bedsus.spotifyapp.data.items

import com.google.gson.annotations.SerializedName

class ItemsApiModel<T>(
    @SerializedName("items") val items: List<T>,
)