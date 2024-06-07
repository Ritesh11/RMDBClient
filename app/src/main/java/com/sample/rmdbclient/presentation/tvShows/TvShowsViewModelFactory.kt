package com.sample.rmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.GetTvShowUseCase
import com.sample.rmdbclient.domain.useCase.tvShowUseCase.UpdateTvShowUseCase

class TvShowsViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}