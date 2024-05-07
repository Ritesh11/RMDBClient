package com.sample.rmdbclient.presentation.di.movie

import com.sample.rmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent
import javax.inject.Inject

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {


    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}