package ru.bedsus.spotifyapp.modules.track.mapper

import ru.bedsus.core.repository.Mapper
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.modules.album.mapper.AlbumApiToSimpleAlbumMapper
import ru.bedsus.spotifyapp.modules.artist.mapper.ArtistApiToArtistMapper
import ru.bedsus.spotifyapp.modules.track.models.SimpleTrack
import ru.bedsus.spotifyapp.modules.track.models.TrackApi

object TrackApiToSimpleTrackMapper : Mapper<TrackApi, SimpleTrack> {
    override fun map(input: TrackApi): SimpleTrack {
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