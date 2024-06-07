package com.sample.rmdbclient.presentation.di.tvShow

import com.sample.rmdbclient.domain.useCase.tvShowUseCase.GetTvShowUseCase
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.UpdateTvShowUseCase
import com.sample.rmdbclient.presentation.tvShows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(getTvShowUseCase: GetTvShowUseCase,
                                       updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowsViewModelFactory{
        return TvShowsViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }
}