package com.sample.rmdbclient.data.repository.movie.dataSourceImpl

import com.sample.rmdbclient.data.api.RMDBService
import com.sample.rmdbclient.data.model.movies.MovieList
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val rmdbService: RMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return rmdbService.getTrendingMovie(apiKey)
    }
}