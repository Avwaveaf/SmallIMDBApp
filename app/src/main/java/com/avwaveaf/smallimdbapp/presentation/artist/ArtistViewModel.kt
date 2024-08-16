package com.avwaveaf.smallimdbapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.avwaveaf.smallimdbapp.domain.usecase.GetArtistUseCase
import com.avwaveaf.smallimdbapp.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):ViewModel() {

    fun getArtists() = liveData{
        val artists = getArtistUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData{
        val artists = updateArtistUseCase.execute()
        emit(artists)
    }

}