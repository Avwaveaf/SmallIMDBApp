package com.avwaveaf.smallimdbapp.presentation

import android.app.Application
import com.avwaveaf.smallimdbapp.BuildConfig
import com.avwaveaf.smallimdbapp.presentation.di.Injector
import com.avwaveaf.smallimdbapp.presentation.di.artist.ArtistSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.core.AppComponent
import com.avwaveaf.smallimdbapp.presentation.di.core.ApplicationModule
import com.avwaveaf.smallimdbapp.presentation.di.core.DaggerAppComponent
import com.avwaveaf.smallimdbapp.presentation.di.core.NetworkModule
import com.avwaveaf.smallimdbapp.presentation.di.core.RemoteDataSourceModule
import com.avwaveaf.smallimdbapp.presentation.di.movie.MovieSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubCompoenent().create()
    }

}