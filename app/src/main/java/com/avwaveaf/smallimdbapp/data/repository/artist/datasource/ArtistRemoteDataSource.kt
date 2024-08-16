package com.avwaveaf.smallimdbapp.data.repository.artist.datasource

import com.avwaveaf.smallimdbapp.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}