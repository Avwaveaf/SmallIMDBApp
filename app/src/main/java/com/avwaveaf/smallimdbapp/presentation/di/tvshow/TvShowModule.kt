package com.avwaveaf.smallimdbapp.presentation.di.tvshow

import com.avwaveaf.smallimdbapp.domain.usecase.GetTvShowsUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateTvShowUseCase
import com.avwaveaf.smallimdbapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowUseCase)
    }
}