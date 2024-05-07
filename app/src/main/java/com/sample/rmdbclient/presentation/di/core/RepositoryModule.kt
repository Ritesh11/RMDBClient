package com.sample.rmdbclient.presentation.di.core

import com.sample.rmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.sample.rmdbclient.data.repository.movie.MovieRepositoryImpl
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.sample.rmdbclient.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.sample.rmdbclient.data.repository.tvShow.TvShowsRepositoryImpl
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsCacheDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.sample.rmdbclient.domain.repository.ArtistRepository
import com.sample.rmdbclient.domain.repository.MovieRepository
import com.sample.rmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource
    ): TvShowRepository{

        return TvShowsRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowsLocalDataSource,
            tvShowsCacheDataSource
        )
    }
    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

}