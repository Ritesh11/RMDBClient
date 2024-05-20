package com.sample.rmdbclient.data.repository.tvShow.dataSourceImpl

import com.sample.rmdbclient.data.api.RMDBService
import com.sample.rmdbclient.data.model.tvshow.TvShowList
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val rmdbService: RMDBService,
    private val apiKey: String
) :
    TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return rmdbService.getTrendingTvShows(apiKey)
    }
}