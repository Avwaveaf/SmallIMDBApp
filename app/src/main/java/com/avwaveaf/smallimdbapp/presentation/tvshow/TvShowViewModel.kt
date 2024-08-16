package com.avwaveaf.smallimdbapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.avwaveaf.smallimdbapp.domain.usecase.GetTvShowsUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val shows = getTvShowsUseCase.execute()
        emit(shows)
    }

    fun updateTvShows() = liveData {
        val shows = updateTvShowUseCase.execute()
        emit(shows)
    }
}