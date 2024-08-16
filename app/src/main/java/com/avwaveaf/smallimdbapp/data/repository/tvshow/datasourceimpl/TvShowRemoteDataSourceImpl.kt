package com.avwaveaf.smallimdbapp.data.repository.tvshow.datasourceimpl

import com.avwaveaf.smallimdbapp.data.api.TMDBService
import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShowList
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTVShows(apiKey)
    }
}