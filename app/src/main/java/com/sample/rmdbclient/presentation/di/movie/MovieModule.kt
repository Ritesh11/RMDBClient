package com.sample.rmdbclient.presentation.di.movie

import com.sample.rmdbclient.domain.useCase.movieUseCase.GetMoviesUseCase
import com.sample.rmdbclient.domain.useCase.movieUseCase.UpdateMovieUseCase
import com.sample.rmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieModule() {

    @ActivityScoped
    @Provides
    fun providesMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                      updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase,updateMovieUseCase)
    }
}