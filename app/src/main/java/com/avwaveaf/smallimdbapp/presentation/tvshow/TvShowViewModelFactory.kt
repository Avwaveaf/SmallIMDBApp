package com.avwaveaf.smallimdbapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avwaveaf.smallimdbapp.domain.usecase.GetTvShowsUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowUseCase) as T
    }
}