package com.sample.rmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.GetTvShowUseCase

class TvShowsViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: GetTvShowUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}