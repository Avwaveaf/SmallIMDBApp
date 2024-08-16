package com.avwaveaf.smallimdbapp.data.repository.movie

import android.util.Log
import com.avwaveaf.smallimdbapp.data.model.movie.Movie
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.CacheMovieDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.avwaveaf.smallimdbapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: CacheMovieDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()

        movieLocalDataSource.deleteAllMovies()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)

        return newListOfMovies
    }

     private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val res = movieRemoteDataSource.getMovies()
            val data = res.body()
            if (data != null) {
                movieList = data.movies
            }
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            // get movies from api
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMovieFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMovieFromCache()
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            // get movies from api
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }

        return movieList
    }
}