package com.avwaveaf.smallimdbapp.data.repository.artist.datasourceimpl

import com.avwaveaf.smallimdbapp.data.model.artist.Artist
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}