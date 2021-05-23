package ru.bedsus.spotifyapp.data.artist.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.data.artist.models.ArtistItem
import ru.bedsus.spotifyapp.data.artist.models.ArtistApiModel
import ru.bedsus.spotifyapp.data.image.mapper.getBigImage

object ArtistApiToArtistMapper : Mapper<ArtistApiModel, ArtistItem> {
    override fun map(input: ArtistApiModel): ArtistItem {
        input.apply {
            return ArtistItem(
                id = id ?: "",
                name = name ?: "",
                href = href ?: "",
                uri = uri ?: "",
                image = getBigImage(images),
                popularity = popularity ?: 0,
                genres = genres ?: listOf()
            )
        }
    }
}