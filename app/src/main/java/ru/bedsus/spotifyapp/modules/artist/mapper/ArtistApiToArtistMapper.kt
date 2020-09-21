package ru.bedsus.spotifyapp.modules.artist.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.spotifyapp.modules.artist.models.Artist
import ru.bedsus.spotifyapp.modules.artist.models.ArtistApi
import ru.bedsus.spotifyapp.modules.image.mapper.getBigImage

object ArtistApiToArtistMapper : Mapper<ArtistApi, Artist> {
    override fun map(input: ArtistApi): Artist {
        input.apply {
            return Artist(
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