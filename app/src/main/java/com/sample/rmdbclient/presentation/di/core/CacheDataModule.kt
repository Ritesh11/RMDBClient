package com.sample.rmdbclient.presentation.di.core

import com.sample.rmdbclient.data.db.RMDBDatabase
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.sample.rmdbclient.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.sample.rmdbclient.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.sample.rmdbclient.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.sample.rmdbclient.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsCacheDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSourceImpl.TvShowsCacheDataSourceImpl
import com.sample.rmdbclient.data.repository.tvShow.dataSourceImpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideTvShowsCacheDataSource(): TvShowsCacheDataSource {
        return TvShowsCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}