package com.avwaveaf.smallimdbapp.domain.usecase

import com.avwaveaf.smallimdbapp.data.model.artist.Artist
import com.avwaveaf.smallimdbapp.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}