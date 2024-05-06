package com.sample.rmdbclient.data.repository.tvShow

import android.util.Log
import com.sample.rmdbclient.data.api.model.tvshow.TvShow
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsCacheDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.sample.rmdbclient.domain.repository.TvShowRepository

class TvShowsRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource
) : TvShowRepository {
    override suspend fun getTVShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TvShow>? {
        val newTvShows = getTvShowsFromApi()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowToDataBase(newTvShows)
        tvShowsCacheDataSource.saveTvShowsToCache(newTvShows)
        return newTvShows
    }

    private suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShow: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShow = body.tvShows
            }
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        return tvShow
    }

    private suspend fun getTvShowsFromDb(): List<TvShow> {
        lateinit var tvShow: List<TvShow>

        try {
            tvShow = tvShowsLocalDataSource.getTvShowFromDataBase()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (tvShow.size > 0) {
            return tvShow
        } else {
            tvShow = getTvShowsFromApi()
            tvShowsLocalDataSource.saveTvShowToDataBase(tvShow)
        }

        return tvShow
    }

    private suspend fun getTvShowsFromCache(): List<TvShow>? {
        lateinit var tvShow: List<TvShow>

        try {
            tvShow = tvShowsCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (tvShow.size > 0) {
            return tvShow
        } else {
            tvShow = getTvShowsFromDb()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShow)
        }

        return tvShow
    }
}