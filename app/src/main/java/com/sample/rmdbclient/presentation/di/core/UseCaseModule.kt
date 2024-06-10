package com.sample.rmdbclient.presentation.di.core

import com.sample.rmdbclient.domain.repository.ArtistRepository
import com.sample.rmdbclient.domain.repository.MovieRepository
import com.sample.rmdbclient.domain.repository.TvShowRepository
import com.sample.rmdbclient.domain.useCase.artistUseCase.GetArtistUseCase
import com.sample.rmdbclient.domain.useCase.artistUseCase.UpdateArtistUseCase
import com.sample.rmdbclient.domain.useCase.movieUseCase.GetMoviesUseCase
import com.sample.rmdbclient.domain.useCase.movieUseCase.UpdateMovieUseCase
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.GetTvShowUseCase
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Provides
    fun providesGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun providesUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }
    @Provides
    fun providesGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun providesUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun providesGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }

}