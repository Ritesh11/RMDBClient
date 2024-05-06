package com.sample.rmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.GetTvShowUseCase

class TvShowsViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: GetTvShowUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShows = getTvShowUseCase.execute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val tvShows = updateTvShowUseCase.execute()
        emit(tvShows)
    }

}