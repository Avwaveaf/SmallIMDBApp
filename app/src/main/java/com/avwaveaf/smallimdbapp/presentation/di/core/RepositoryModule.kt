package com.avwaveaf.smallimdbapp.presentation.di.core

import com.avwaveaf.smallimdbapp.data.repository.artist.ArtistRepositoryImpl
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.MovieRepositoryImpl
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.CacheMovieDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.TvShowRepositoryImpl
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.avwaveaf.smallimdbapp.domain.repository.ArtistRepository
import com.avwaveaf.smallimdbapp.domain.repository.MovieRepository
import com.avwaveaf.smallimdbapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: CacheMovieDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource

        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

}