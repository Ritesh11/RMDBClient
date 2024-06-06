package com.sample.rmdbclient.presentation.artist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.sample.rmdbclient.data.model.artist.Artist
import com.sample.rmdbclient.data.repository.artist.FakeArtistRepository
import com.sample.rmdbclient.domain.useCase.artistUseCase.GetArtistUseCase
import com.sample.rmdbclient.domain.useCase.artistUseCase.UpdateArtistUseCase
import com.sample.rmdbclient.getOrAwaitValue

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtistViewModelTest {

    private lateinit var viewModel: ArtistViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val artistRepository = FakeArtistRepository()
        val getArtistUseCase = GetArtistUseCase(artistRepository)
        val updateArtistUseCase = UpdateArtistUseCase(artistRepository)
        viewModel = ArtistViewModel(getArtistUseCase, updateArtistUseCase)
    }

    @Test
    fun getArtist_returnsArtist() {
        val artists = mutableListOf<Artist>()
        artists.add(Artist(1, "Artist 1", 1.0, "Profile Path 1"))
        artists.add(Artist(2, "Artist 2", 2.0, "Profile Path 2"))
        artists.add(Artist(3, "Artist 3", 3.0, "Profile Path 3"))

        val currentArtist = viewModel.getArtist().getOrAwaitValue()
        assertThat(currentArtist).isEqualTo(artists)
    }

    @Test
    fun updateArtist_returnsUpdatedArtist() {
        val artists = mutableListOf<Artist>()
        artists.add(Artist(4, "Artist 4", 4.0, "Profile Path 4"))
        artists.add(Artist(5, "Artist 5", 5.0, "Profile Path 5"))
        artists.add(Artist(6, "Artist 6", 6.0, "Profile Path 6"))

        val updatedArtist = viewModel.updateArtist().getOrAwaitValue()
        assertThat(updatedArtist).isEqualTo(artists)
    }
}