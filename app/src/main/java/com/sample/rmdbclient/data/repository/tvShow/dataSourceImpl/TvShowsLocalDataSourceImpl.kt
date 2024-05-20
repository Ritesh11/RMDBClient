package com.sample.rmdbclient.data.repository.tvShow.dataSourceImpl

import com.sample.rmdbclient.data.model.tvshow.TvShow
import com.sample.rmdbclient.data.db.TvShowDao
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(private val dao: TvShowDao) : TvShowsLocalDataSource {
    override suspend fun getTvShowFromDataBase(): List<TvShow> {
        return dao.getTvShows()
    }

    override suspend fun saveTvShowToDataBase(tvShows: List<TvShow>) {
        CoroutineScope(IO).launch {
            dao.saveTvShows(tvShows)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            dao.deleteAllTvShows()
        }
    }
}