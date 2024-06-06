package com.sample.rmdbclient.data.repository.artist

import com.sample.rmdbclient.data.model.artist.Artist
import com.sample.rmdbclient.domain.repository.ArtistRepository

class FakeArtistRepository : ArtistRepository {

    private val artists = mutableListOf<Artist>()


    init {
        artists.add(Artist(1, "Artist 1", 1.0, "Profile Path 1"))
        artists.add(Artist(2, "Artist 2", 2.0, "Profile Path 2"))
        artists.add(Artist(3, "Artist 3", 3.0, "Profile Path 3"))
    }

    override suspend fun getArtist(): List<Artist>? {
        return artists
    }

    override suspend fun updateArtist(): List<Artist>? {
        artists.clear()

        artists.add(Artist(4, "Artist 4", 4.0, "Profile Path 4"))
        artists.add(Artist(5, "Artist 5", 5.0, "Profile Path 5"))
        artists.add(Artist(6, "Artist 6", 6.0, "Profile Path 6"))

        return artists
    }
}