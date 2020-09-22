package ru.bedsus.spotifyapp.modules.search.mappers

import ru.bedsus.core.repository.Mapper
import ru.bedsus.core.repository.listMap
import ru.bedsus.spotifyapp.modules.album.mapper.AlbumApiToSimpleAlbumMapper
import ru.bedsus.spotifyapp.modules.artist.mapper.ArtistApiToArtistMapper
import ru.bedsus.spotifyapp.modules.search.models.SearchResult
import ru.bedsus.spotifyapp.modules.search.models.SearchResultApi
import ru.bedsus.spotifyapp.modules.track.mapper.TrackApiToSimpleTrackMapper

object SearchResultApiToSearchResultMapper : Mapper<SearchResultApi, SearchResult> {
    override fun map(input: SearchResultApi): SearchResult {
        input.apply {
            return SearchResult(
                artists = ArtistApiToArtistMapper.listMap(artists?.items) { it.id != null },
                albums = AlbumApiToSimpleAlbumMapper.listMap(albums?.items) { it.id != null },
                tracks = TrackApiToSimpleTrackMapper.listMap(tracks?.items) { it.id != null }
            )
        }
    }
}