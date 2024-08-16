package com.avwaveaf.smallimdbapp.data.repository.movie.datasourceimpl

import com.avwaveaf.smallimdbapp.data.model.movie.Movie
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.CacheMovieDataSource

class CacheMovieDataSourceImpl : CacheMovieDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMovieFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}