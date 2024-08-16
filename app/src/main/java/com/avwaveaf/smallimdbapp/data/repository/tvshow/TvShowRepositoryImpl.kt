package com.avwaveaf.smallimdbapp.data.repository.tvshow

import android.util.Log
import com.avwaveaf.smallimdbapp.data.model.tvshow.TvShow
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.avwaveaf.smallimdbapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.avwaveaf.smallimdbapp.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList = getTvShowFromAPI()

        tvShowLocalDataSource.deleteAllTvShow()
        tvShowLocalDataSource.saveTvShowToDB(newTvShowList)
        tvShowCacheDataSource.saveTvShowToCache(newTvShowList)

        return newTvShowList
    }


    private suspend fun getTvShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val res = tvShowRemoteDataSource.getTvShows()
            val data = res.body()
            if (data != null) {
                tvShowList = data.tvShows
            }
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            // get movies from api
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
             tvShowList= tvShowCacheDataSource.getTvShowFromCache()
        } catch (e: Exception) {
            Log.i("MovieRepositoryImpl", e.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            // get movies from api
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }
}