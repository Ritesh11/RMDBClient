package com.sample.rmdbclient.data.repository.movie.dataSource

import com.sample.rmdbclient.data.api.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDatabase(): List<Movie>
    suspend fun saveMovieToDatabase(movies: List<Movie>)
    suspend fun clearAll()
}