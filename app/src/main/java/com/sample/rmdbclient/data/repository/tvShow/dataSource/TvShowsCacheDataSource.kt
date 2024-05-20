package com.sample.rmdbclient.data.repository.tvShow.dataSource

import com.sample.rmdbclient.data.model.tvshow.TvShow

interface TvShowsCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)

}