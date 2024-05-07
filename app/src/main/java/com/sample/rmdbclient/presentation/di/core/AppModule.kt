package com.sample.rmdbclient.presentation.di.core

import android.content.Context
import com.sample.rmdbclient.presentation.di.artist.ArtistSubComponent
import com.sample.rmdbclient.presentation.di.movie.MovieSubComponent
import com.sample.rmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}