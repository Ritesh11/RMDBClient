package com.sample.rmdbclient.data.repository.artist.dataSource

import com.sample.rmdbclient.data.api.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}