package com.avwaveaf.smallimdbapp.data.repository.movie.datasource

import com.avwaveaf.smallimdbapp.data.model.movie.Movie

interface CacheMovieDataSource {
    suspend fun getMovieFromCache(): List<Movie>
    suspend fun saveMovieToCache(movies:List<Movie>)

}