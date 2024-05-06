package com.sample.rmdbclient.data.repository.tvShow.dataSource

import com.sample.rmdbclient.data.api.model.tvshow.TvShow

interface TvShowsLocalDataSource {

    suspend fun getTvShowFromDataBase() : List<TvShow>
    suspend fun saveTvShowToDataBase(tvShows: List<TvShow>)
    suspend fun clearAll()
}