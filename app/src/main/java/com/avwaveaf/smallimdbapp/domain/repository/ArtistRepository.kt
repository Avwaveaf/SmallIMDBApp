package com.avwaveaf.smallimdbapp.domain.repository

import com.avwaveaf.smallimdbapp.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists():List<Artist>?
}