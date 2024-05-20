package com.sample.rmdbclient.domain.repository

import com.sample.rmdbclient.data.model.movies.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}