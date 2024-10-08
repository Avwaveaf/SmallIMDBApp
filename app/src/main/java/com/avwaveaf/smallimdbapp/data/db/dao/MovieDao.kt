package com.avwaveaf.smallimdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avwaveaf.smallimdbapp.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<Movie>
}