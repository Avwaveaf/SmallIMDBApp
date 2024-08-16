package com.avwaveaf.smallimdbapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.avwaveaf.smallimdbapp.data.db.SmallIMDBDatabase
import com.avwaveaf.smallimdbapp.data.db.dao.ArtistDao
import com.avwaveaf.smallimdbapp.data.db.dao.MovieDao
import com.avwaveaf.smallimdbapp.data.db.dao.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): SmallIMDBDatabase {
        return Room.databaseBuilder(context, SmallIMDBDatabase::class.java, "smallimdb_db_client")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(smallIMDBDatabase: SmallIMDBDatabase): MovieDao {
        return smallIMDBDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(smallIMDBDatabase: SmallIMDBDatabase): TvShowDao {
        return smallIMDBDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(smallIMDBDatabase: SmallIMDBDatabase): ArtistDao {
        return smallIMDBDatabase.artistDao()
    }


}