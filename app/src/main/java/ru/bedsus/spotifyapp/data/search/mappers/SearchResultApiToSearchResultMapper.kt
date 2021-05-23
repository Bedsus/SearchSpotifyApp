package ru.bedsus.spotifyapp.data.search.mappers

import ru.bedsus.core.repository.Mapper
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.data.album.mapper.AlbumApiToSimpleAlbumMapper
import ru.bedsus.spotifyapp.data.artist.mapper.ArtistApiToArtistMapper
import ru.bedsus.spotifyapp.data.search.models.SearchResult
import ru.bedsus.spotifyapp.data.search.models.SearchResultApiModel
import ru.bedsus.spotifyapp.data.track.mapper.TrackApiToSimpleTrackMapper

object SearchResultApiToSearchResultMapper : Mapper<SearchResultApiModel, SearchResult> {
    override fun map(input: SearchResultApiModel): SearchResult {
        input.apply {
            return SearchResult(
                artists = ArtistApiToArtistMapper.listMap(artists?.items) { it.id != null },
                albums = AlbumApiToSimpleAlbumMapper.listMap(albums?.items) { it.id != null },
                tracks = TrackApiToSimpleTrackMapper.listMap(tracks?.items) { it.id != null }
            )
        }
    }
}