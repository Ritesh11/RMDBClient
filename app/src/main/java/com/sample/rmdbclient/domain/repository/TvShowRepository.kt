package com.sample.rmdbclient.domain.repository

import com.sample.rmdbclient.data.api.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTVShows(): List<TvShow>?
    suspend fun updateTVShows(): List<TvShow>?
}