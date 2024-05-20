package com.sample.rmdbclient.data.repository.movie.dataSourceImpl

import com.sample.rmdbclient.data.model.movies.Movie
import com.sample.rmdbclient.data.db.MovieDao
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMovieFromDatabase(): List<Movie> {
       return movieDao.getMovies()
    }

    override suspend fun saveMovieToDatabase(movies: List<Movie>) {
       CoroutineScope(IO).launch {
           movieDao.saveMovies(movies)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}