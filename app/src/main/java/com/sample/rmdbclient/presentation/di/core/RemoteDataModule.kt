package com.sample.rmdbclient.presentation.di.core

import com.sample.rmdbclient.data.api.RMDBService
import com.sample.rmdbclient.data.db.RMDBDatabase
import com.sample.rmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.sample.rmdbclient.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.sample.rmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.sample.rmdbclient.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.sample.rmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.sample.rmdbclient.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule(private val apiKey: String) {


    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(rmdbService: RMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(rmdbService, apiKey)
    }
 @Singleton
    @Provides
    fun provideTvShowsRemoteDataSource(rmdbService: RMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(rmdbService, apiKey)
    }
 @Singleton
    @Provides
    fun provideArtistRemoteDataSource(rmdbService: RMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(rmdbService, apiKey)
    }

}