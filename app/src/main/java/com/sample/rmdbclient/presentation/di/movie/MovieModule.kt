package com.sample.rmdbclient.presentation.di.movie

import com.sample.rmdbclient.domain.useCase.movieUseCase.GetMoviesUseCase
import com.sample.rmdbclient.domain.useCase.movieUseCase.UpdateMovieUseCase
import com.sample.rmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule() {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                      updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase,updateMovieUseCase)
    }
}