package com.sample.rmdbclient.data.repository.artist.dataSource

import com.sample.rmdbclient.data.api.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDb(newArtists: List<Artist>)

    suspend fun clearAll()

}