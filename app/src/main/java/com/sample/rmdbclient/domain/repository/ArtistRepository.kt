package com.sample.rmdbclient.domain.repository

import com.sample.rmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}