package ru.bedsus.spotifyapp.modules.image.mapper

import ru.bedsus.spotifyapp.modules.image.models.Image
import ru.bedsus.spotifyapp.modules.image.models.ImageApi

fun getBigImage(list: List<ImageApi>?): Image {
    return list?.map {
        Image(
            url = it.url ?: "",
            height = it.height ?: 0,
            width = it.width ?: 0
        )
    }?.maxByOrNull { it.height } ?: Image("",640,640)
}