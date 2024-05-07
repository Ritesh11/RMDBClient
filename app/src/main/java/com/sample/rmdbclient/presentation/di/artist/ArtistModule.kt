package com.sample.rmdbclient.presentation.di.artist

import com.sample.rmdbclient.domain.useCase.artistUseCase.GetArtistUseCase
import com.sample.rmdbclient.domain.useCase.artistUseCase.UpdateArtistUseCase
import com.sample.rmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}