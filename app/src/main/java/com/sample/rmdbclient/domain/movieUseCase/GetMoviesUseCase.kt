package com.sample.rmdbclient.domain.movieUseCase

import com.sample.rmdbclient.data.api.model.movies.Movie
import com.sample.rmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val moviewRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = moviewRepository.getMovies()
}