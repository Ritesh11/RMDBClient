package com.sample.rmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.sample.rmdbclient.data.db.ArtistDao
import com.sample.rmdbclient.data.db.MovieDao
import com.sample.rmdbclient.data.db.RMDBDatabase
import com.sample.rmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): RMDBDatabase{
        return Room.databaseBuilder(context, RMDBDatabase::class.java,"rmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(rmdbDataBase: RMDBDatabase): MovieDao{
        return rmdbDataBase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowsDao(tbdbDataBase: RMDBDatabase): TvShowDao{
        return tbdbDataBase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tbdbDataBase: RMDBDatabase): ArtistDao{
        return tbdbDataBase.artistDao()
    }
}
