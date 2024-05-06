package com.sample.rmdbclient.domain.tvShowUseCase

import com.sample.rmdbclient.data.api.model.tvshow.TvShow
import com.sample.rmdbclient.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTVShows()
}