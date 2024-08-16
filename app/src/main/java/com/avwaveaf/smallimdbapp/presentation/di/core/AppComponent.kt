package com.avwaveaf.smallimdbapp.presentation.di.core

import com.avwaveaf.smallimdbapp.presentation.di.artist.ArtistSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.movie.MovieSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class,
        CacheDataSourceModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubCompoenent(): ArtistSubComponent.Factory

}