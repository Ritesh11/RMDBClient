package com.sample.rmdbclient.presentation.di.core

import com.sample.rmdbclient.data.api.RMDBService
import com.sample.rmdbclient.data.db.ArtistDao
import com.sample.rmdbclient.data.db.MovieDao
import com.sample.rmdbclient.data.db.RMDBDatabase
import com.sample.rmdbclient.data.db.TvShowDao
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.sample.rmdbclient.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.sample.rmdbclient.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSourceImpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun provideTvShowsLocalDataSource(tvShowDao: TvShowDao): TvShowsLocalDataSource {
        return TvShowsLocalDataSourceImpl(tvShowDao)
    }
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}