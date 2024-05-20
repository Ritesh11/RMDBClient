package com.sample.rmdbclient.data.repository.movie.dataSourceImpl

import com.sample.rmdbclient.data.model.movies.Movie
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieCacheDataSource

class MovieCacheDataSourceImpl(): MovieCacheDataSource {

    private var movieList= ArrayList<Movie>()

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override suspend fun getMoviesToCache(): List<Movie> {
        return movieList
    }
}