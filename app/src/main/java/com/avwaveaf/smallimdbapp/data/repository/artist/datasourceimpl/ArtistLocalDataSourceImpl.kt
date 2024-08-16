package com.avwaveaf.smallimdbapp.data.repository.artist.datasourceimpl

import com.avwaveaf.smallimdbapp.data.db.dao.ArtistDao
import com.avwaveaf.smallimdbapp.data.model.artist.Artist
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getAllArtist()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun deleteAllArtist() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}