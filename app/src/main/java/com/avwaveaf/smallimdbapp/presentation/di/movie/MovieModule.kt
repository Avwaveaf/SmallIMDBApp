package com.avwaveaf.smallimdbapp.presentation.di.movie

import com.avwaveaf.smallimdbapp.domain.usecase.GetMoviesUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateMoviesUseCase
import com.avwaveaf.smallimdbapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMoviesUseCase)
    }
}