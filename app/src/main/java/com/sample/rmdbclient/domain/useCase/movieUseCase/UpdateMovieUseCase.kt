package com.sample.rmdbclient.domain.useCase.movieUseCase

import com.sample.rmdbclient.data.api.model.movies.Movie
import com.sample.rmdbclient.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}