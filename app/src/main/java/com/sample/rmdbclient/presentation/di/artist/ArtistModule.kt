package com.sample.rmdbclient.presentation.di.artist

import com.sample.rmdbclient.domain.useCase.artistUseCase.GetArtistUseCase
import com.sample.rmdbclient.domain.useCase.artistUseCase.UpdateArtistUseCase
import com.sample.rmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ArtistModule {

    @ActivityScoped
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}