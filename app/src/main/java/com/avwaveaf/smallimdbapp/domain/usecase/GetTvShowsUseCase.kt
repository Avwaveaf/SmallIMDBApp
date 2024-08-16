package com.avwaveaf.smallimdbapp.domain.usecase

import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow
import com.avwaveaf.smallimdbapp.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}