package com.avwaveaf.smallimdbapp.data.repository.artist

import android.util.Log
import com.avwaveaf.smallimdbapp.data.model.artist.Artist
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.avwaveaf.smallimdbapp.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistFromAPI()

        artistLocalDataSource.deleteAllArtist()
        artistLocalDataSource.saveArtistToDB(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)

        return newArtistList
    }

     suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val res = artistRemoteDataSource.getArtist()
            val data = res.body()

            if (data != null) {
                artistList = data.artists
            }

        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }

        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }


}