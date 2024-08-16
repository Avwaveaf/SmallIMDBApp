package com.avwaveaf.smallimdbapp.presentation.di.core

import com.avwaveaf.smallimdbapp.data.db.dao.ArtistDao
import com.avwaveaf.smallimdbapp.data.db.dao.MovieDao
import com.avwaveaf.smallimdbapp.data.db.dao.TvShowDao
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}