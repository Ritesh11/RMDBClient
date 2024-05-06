package com.sample.rmdbclient.data.repository.tvShow.dataSourceImpl

import com.sample.rmdbclient.data.api.model.tvshow.TvShow
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsCacheDataSource

class TvShowsCacheDataSourceImpl: TvShowsCacheDataSource {

    private var tvShows = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShows
    }

    override suspend fun saveTvShowsToCache(newTvShows: List<TvShow>) {
        tvShows.clear()
        tvShows = ArrayList(newTvShows)
    }
}