package com.sample.rmdbclient.domain.useCase.movieUseCase

import com.sample.rmdbclient.data.model.movies.Movie
import com.sample.rmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val moviewRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = moviewRepository.getMovies()
}