package com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource

import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShows:List<TvShow>)
}