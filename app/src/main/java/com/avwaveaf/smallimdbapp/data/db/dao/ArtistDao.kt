package com.avwaveaf.smallimdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avwaveaf.smallimdbapp.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)

    @Query("SELECT * FROM artist")
    suspend fun getAllArtist(): List<Artist>

    @Query("DELETE FROM artist")
    suspend fun deleteAllArtist()



}