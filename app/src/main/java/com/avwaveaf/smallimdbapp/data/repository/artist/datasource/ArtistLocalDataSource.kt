package com.avwaveaf.smallimdbapp.data.repository.artist.datasource

import com.avwaveaf.smallimdbapp.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artists: List<Artist>)
    suspend fun deleteAllArtist()
}