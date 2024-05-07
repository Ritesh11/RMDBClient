package com.sample.rmdbclient.presentation.di.tvShow

import com.sample.rmdbclient.presentation.di.artist.ArtistSubComponent
import com.sample.rmdbclient.presentation.tvShows.TvShowActivity
import dagger.Subcomponent
import javax.inject.Inject

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}