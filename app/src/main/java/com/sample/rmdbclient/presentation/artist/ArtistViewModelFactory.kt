package com.sample.rmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.rmdbclient.domain.useCase.artistUseCase.GetArtistUseCase
import com.sample.rmdbclient.domain.useCase.artistUseCase.UpdateArtistUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
    }
}