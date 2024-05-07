package com.sample.rmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.rmdbclient.domain.useCase.movieUseCase.GetMoviesUseCase
import com.sample.rmdbclient.domain.useCase.movieUseCase.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMovieUseCase) as T
    }

}