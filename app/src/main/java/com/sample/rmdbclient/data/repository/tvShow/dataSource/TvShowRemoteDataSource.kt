package com.sample.rmdbclient.data.repository.tvShow.dataSource

import com.sample.rmdbclient.data.api.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>

}