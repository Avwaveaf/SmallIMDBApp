package com.avwaveaf.smallimdbapp.domain.repository

import com.avwaveaf.smallimdbapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}