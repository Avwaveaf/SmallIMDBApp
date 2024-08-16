package com.avwaveaf.smallimdbapp.data.repository.artist.datasource

import com.avwaveaf.smallimdbapp.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artists:List<Artist>)
}