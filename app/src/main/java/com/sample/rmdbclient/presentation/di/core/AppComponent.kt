package com.sample.rmdbclient.presentation.di.core

import com.sample.rmdbclient.presentation.di.artist.ArtistSubComponent
import com.sample.rmdbclient.presentation.di.movie.MovieSubComponent
import com.sample.rmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
CacheDataModule::class,
DatabaseModule::class,
LocalDataModule::class,
NetModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UseCaseModule::class])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory

}