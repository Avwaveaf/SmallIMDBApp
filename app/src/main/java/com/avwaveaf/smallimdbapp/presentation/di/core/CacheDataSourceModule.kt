package com.avwaveaf.smallimdbapp.presentation.di.core

import com.avwaveaf.smallimdbapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.avwaveaf.smallimdbapp.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.avwaveaf.smallimdbapp.data.repository.movie.datasource.CacheMovieDataSource
import com.avwaveaf.smallimdbapp.data.repository.movie.datasourceimpl.CacheMovieDataSourceImpl
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSourceModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): CacheMovieDataSource {
        return CacheMovieDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
}