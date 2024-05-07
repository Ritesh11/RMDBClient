package com.sample.rmdbclient.presentation

import android.app.Application
import com.sample.rmdbclient.BuildConfig
import com.sample.rmdbclient.presentation.di.Injector
import com.sample.rmdbclient.presentation.di.artist.ArtistSubComponent
import com.sample.rmdbclient.presentation.di.core.AppComponent
import com.sample.rmdbclient.presentation.di.core.AppModule
import com.sample.rmdbclient.presentation.di.core.DaggerAppComponent
import com.sample.rmdbclient.presentation.di.core.NetModule
import com.sample.rmdbclient.presentation.di.core.RemoteDataModule
import com.sample.rmdbclient.presentation.di.movie.MovieSubComponent
import com.sample.rmdbclient.presentation.di.tvShow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
       return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}