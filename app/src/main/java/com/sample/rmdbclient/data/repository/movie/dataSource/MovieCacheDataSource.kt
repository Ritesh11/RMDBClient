package com.sample.rmdbclient.data.repository.movie.dataSource

import com.sample.rmdbclient.data.api.model.movies.Movie

interface MovieCacheDataSource {

    suspend fun saveMovieToCache(movies: List<Movie>)
    suspend fun getMoviesToCache(): List<Movie>
}