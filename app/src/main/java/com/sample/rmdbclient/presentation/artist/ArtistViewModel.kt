package com.sample.rmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sample.rmdbclient.domain.useCase.artistUseCase.GetArtistUseCase
import com.sample.rmdbclient.domain.useCase.artistUseCase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtist() = liveData {
        val artists = getArtistUseCase.execute()
        emit(artists)
    }
    fun updateArtist() = liveData {
        val artists = updateArtistUseCase.execute()
        emit(artists)
    }
}