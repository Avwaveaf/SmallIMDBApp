package com.avwaveaf.smallimdbapp.data.repository.tvshow.datasourceimpl

import com.avwaveaf.smallimdbapp.data.db.dao.TvShowDao
import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.insertTvShows(tvShows)
        }
    }

    override suspend fun deleteAllTvShow() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}