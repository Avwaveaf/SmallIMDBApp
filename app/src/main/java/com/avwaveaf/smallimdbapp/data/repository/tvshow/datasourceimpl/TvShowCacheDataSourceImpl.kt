package com.avwaveaf.smallimdbapp.data.repository.tvshow.datasourceimpl

import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

}