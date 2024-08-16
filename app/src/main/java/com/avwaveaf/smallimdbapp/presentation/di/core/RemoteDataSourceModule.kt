package com.avwaveaf.smallimdbapp.presentation.di.core

import com.avwaveaf.smallimdbapp.data.api.TMDBService
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.avwaveaf.smallimdbapp.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }


}