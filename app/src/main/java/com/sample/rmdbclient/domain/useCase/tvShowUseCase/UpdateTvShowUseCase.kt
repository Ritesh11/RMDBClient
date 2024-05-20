package com.sample.rmdbclient.domain.useCase.tvShowUseCase

import com.sample.rmdbclient.data.model.tvshow.TvShow
import com.sample.rmdbclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTVShows()
}