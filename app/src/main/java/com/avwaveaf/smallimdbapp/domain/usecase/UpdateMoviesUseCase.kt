package com.avwaveaf.smallimdbapp.domain.usecase

import com.avwaveaf.smallimdbapp.data.model.movie.Movie
import com.avwaveaf.smallimdbapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}