package com.avwaveaf.smallimdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM tv_show")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM tv_show")
    suspend fun getAllTvShows():List<TvShow>
}