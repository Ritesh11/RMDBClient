package com.sample.rmdbclient.data.repository.artist.dataSource

import com.sample.rmdbclient.data.api.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(newArtists: List<Artist>)
}