package com.sample.rmdbclient.data.repository.movie.dataSource

import com.sample.rmdbclient.data.api.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}