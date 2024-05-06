package com.sample.rmdbclient.domain.artistUseCase

import com.sample.rmdbclient.data.api.model.artist.Artist
import com.sample.rmdbclient.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>?= artistRepository.getArtist()
}