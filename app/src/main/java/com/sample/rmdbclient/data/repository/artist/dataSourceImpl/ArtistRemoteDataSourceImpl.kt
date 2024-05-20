package com.sample.rmdbclient.data.repository.artist.dataSourceImpl

import com.sample.rmdbclient.data.api.RMDBService
import com.sample.rmdbclient.data.model.artist.ArtistList
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val rmdbService: RMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return rmdbService.getTrendingArtist(apiKey)
    }
}