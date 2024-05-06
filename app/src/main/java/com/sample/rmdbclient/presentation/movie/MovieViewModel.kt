package com.sample.rmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sample.rmdbclient.domain.useCase.movieUseCase.GetMoviesUseCase
import com.sample.rmdbclient.domain.useCase.movieUseCase.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {


    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }
    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}