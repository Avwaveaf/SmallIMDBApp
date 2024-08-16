package com.avwaveaf.smallimdbapp.data.repository.movie.datasource

import com.avwaveaf.smallimdbapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}