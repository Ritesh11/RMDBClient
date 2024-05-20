package com.sample.rmdbclient.domain.useCase.artistUseCase

import com.sample.rmdbclient.data.model.artist.Artist
import com.sample.rmdbclient.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>?= artistRepository.getArtist()
}