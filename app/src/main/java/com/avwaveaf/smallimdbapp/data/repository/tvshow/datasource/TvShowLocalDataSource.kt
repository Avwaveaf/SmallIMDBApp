package com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource

import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShows: List<TvShow>)
    suspend fun deleteAllTvShow()
}