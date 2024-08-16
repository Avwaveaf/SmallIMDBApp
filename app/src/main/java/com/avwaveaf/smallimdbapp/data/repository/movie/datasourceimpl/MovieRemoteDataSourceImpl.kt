package com.avwaveaf.smallimdbapp.data.repository.movie.datasourceimpl

import com.avwaveaf.smallimdbapp.data.api.TMDBService
import com.avwaveaf.smallimdbapp.data.model.movie.MovieList
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) :
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }

}