package ru.bedsus.spotifyapp.data.track.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.data.album.mapper.AlbumApiToSimpleAlbumMapper
import ru.bedsus.spotifyapp.data.artist.mapper.ArtistApiToArtistMapper
import ru.bedsus.spotifyapp.data.track.models.SimpleTrack
import ru.bedsus.spotifyapp.data.track.models.TrackApiModel

object TrackApiToSimpleTrackMapper : Mapper<TrackApiModel, SimpleTrack> {
    override fun map(input: TrackApiModel): SimpleTrack {
        input.apply {
            return SimpleTrack(
                artists = ArtistApiToArtistMapper.listMap(artists) { it.id != null },
                id = id ?: "",
                name = name ?: "",
                uri = uri ?: "",
                album = if (album != null) AlbumApiToSimpleAlbumMapper.map(album) else null
            )
        }
    }
}