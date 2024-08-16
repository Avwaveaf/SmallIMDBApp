package com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource

import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}