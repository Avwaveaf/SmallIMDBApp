package com.avwaveaf.smallimdbapp.presentation.di.artist

import com.avwaveaf.smallimdbapp.domain.usecase.GetArtistUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateArtistUseCase
import com.avwaveaf.smallimdbapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}