package com.sample.rmdbclient.presentation.tvShows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.sample.rmdbclient.data.model.artist.Artist
import com.sample.rmdbclient.data.model.tvshow.TvShow
import com.sample.rmdbclient.data.repository.tvShow.FakeTvShowRepository
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.GetTvShowUseCase
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.UpdateTvShowUseCase
import com.sample.rmdbclient.getOrAwaitValue

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowsViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val repository = FakeTvShowRepository()
        val getTvShowsUseCase = GetTvShowUseCase(repository)
        val updateTvShowsUseCase = UpdateTvShowUseCase(repository)
        viewModel = TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase)
    }

    @Test
    fun getTvShows_returnTvShows() {
        val tvShows = mutableListOf<TvShow>()
        tvShows.add(TvShow(1, "1.1.2021", "Name 1", "Overview 1", "Poster Path 1"))
        tvShows.add(TvShow(2, "2.1.2021", "Name 2", "Overview 2", "Poster Path 2"))

        val currentTvShows = viewModel.getTvShows().getOrAwaitValue()
        assertThat(currentTvShows).isEqualTo(tvShows)
    }

    @Test
    fun updateTvShows_returnTvShows() {
        val tvShows = mutableListOf<TvShow>()
        tvShows.add(TvShow(3, "3.1.2021", "Name 3", "Overview 3", "Poster Path 3"))
        tvShows.add(TvShow(4, "4.1.2021", "Name 4", "Overview 4", "Poster Path 4"))

        val updatedTvShows = viewModel.updateTvShows().getOrAwaitValue()
        assertThat(updatedTvShows).isEqualTo(tvShows)
    }
}