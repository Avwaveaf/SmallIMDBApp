package com.avwaveaf.smallimdbapp.data.repository.movie.datasource

import com.avwaveaf.smallimdbapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun deleteAllMovies()
}