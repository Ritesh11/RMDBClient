package com.sample.rmdbclient.data.repository.movie

import android.util.Log
import com.sample.rmdbclient.data.model.movies.Movie
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.sample.rmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
       return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesListFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDatabase(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesListFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }
        return movieList
    }


    suspend fun getMoviesFromDb(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDatabase()

        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesListFromApi()
            movieLocalDataSource.saveMovieToDatabase(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesToCache()
        } catch (e: Exception) {
            Log.e("MyTag", e.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDb()
            movieCacheDataSource.saveMovieToCache(movieList)
        }

        return movieList
    }


}