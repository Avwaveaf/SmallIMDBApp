package com.avwaveaf.smallimdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.avwaveaf.smallimdbapp.data.db.dao.ArtistDao
import com.avwaveaf.smallimdbapp.data.db.dao.MovieDao
import com.avwaveaf.smallimdbapp.data.db.dao.TvShowDao
import com.avwaveaf.smallimdbapp.data.model.artist.Artist
import com.avwaveaf.smallimdbapp.data.model.movie.Movie
import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class SmallIMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDao(): TvShowDao
}