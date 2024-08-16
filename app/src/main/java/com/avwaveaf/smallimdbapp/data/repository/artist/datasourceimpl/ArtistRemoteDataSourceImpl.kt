package com.avwaveaf.smallimdbapp.data.repository.artist.datasourceimpl

import com.avwaveaf.smallimdbapp.data.api.TMDBService
import com.avwaveaf.smallimdbapp.data.model.artist.ArtistList
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val api_key: String
): ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtists(api_key)
    }

}