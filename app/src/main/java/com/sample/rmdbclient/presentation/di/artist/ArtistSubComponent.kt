package com.sample.rmdbclient.presentation.di.artist

import com.sample.rmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent
import javax.inject.Inject

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)


    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}