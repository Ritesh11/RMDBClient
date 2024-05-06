package com.sample.rmdbclient.data.repository.artist.dataSourceImpl

import com.sample.rmdbclient.data.api.model.artist.Artist
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private var artists = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
       return artists
    }

    override suspend fun saveArtistsToCache(newArtists: List<Artist>) {
        artists.clear()
        artists = ArrayList(newArtists)
    }
}