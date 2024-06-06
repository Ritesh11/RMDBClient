package com.sample.rmdbclient.data.repository.tvShow

import com.sample.rmdbclient.data.model.tvshow.TvShow
import com.sample.rmdbclient.domain.repository.TvShowRepository

class FakeTvShowRepository : TvShowRepository {

    private val tvShows = mutableListOf<TvShow>()

    init {
        tvShows.add(TvShow(1, "1.1.2021", "Name 1", "Overview 1", "Poster Path 1"))
        tvShows.add(TvShow(2, "2.1.2021", "Name 2", "Overview 2", "Poster Path 2"))
    }

    override suspend fun getTVShows(): List<TvShow>? {
        return tvShows
    }

    override suspend fun updateTVShows(): List<TvShow>? {
        tvShows.clear()
        tvShows.add(TvShow(3, "3.1.2021", "Name 3", "Overview 3", "Poster Path 3"))
        tvShows.add(TvShow(4, "4.1.2021", "Name 4", "Overview 4", "Poster Path 4"))
        return tvShows
    }
}