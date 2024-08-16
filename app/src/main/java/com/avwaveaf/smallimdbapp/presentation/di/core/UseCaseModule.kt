package com.avwaveaf.smallimdbapp.presentation.di.core

import com.avwaveaf.smallimdbapp.domain.repository.ArtistRepository
import com.avwaveaf.smallimdbapp.domain.repository.MovieRepository
import com.avwaveaf.smallimdbapp.domain.repository.TvShowRepository
import com.avwaveaf.smallimdbapp.domain.usecase.GetArtistUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.GetMoviesUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.GetTvShowsUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateArtistUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateMoviesUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }




}