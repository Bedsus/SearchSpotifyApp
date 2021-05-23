package ru.bedsus.spotifyapp.data.image.mapper

import ru.bedsus.spotifyapp.data.image.models.Image
import ru.bedsus.spotifyapp.data.image.models.ImageApiModel

fun getBigImage(list: List<ImageApiModel>?): Image {
    return list?.map {
        Image(
            url = it.url ?: "",
            height = it.height ?: 0,
            width = it.width ?: 0
        )
    }?.maxByOrNull { it.height } ?: Image("",640,640)
}