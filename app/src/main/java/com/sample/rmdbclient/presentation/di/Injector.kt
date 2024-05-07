package com.sample.rmdbclient.presentation.di

import com.sample.rmdbclient.presentation.di.artist.ArtistSubComponent
import com.sample.rmdbclient.presentation.di.movie.MovieSubComponent
import com.sample.rmdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}