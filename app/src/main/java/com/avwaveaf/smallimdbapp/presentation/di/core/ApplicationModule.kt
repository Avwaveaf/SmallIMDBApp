package com.avwaveaf.smallimdbapp.presentation.di.core

import android.content.Context
import com.avwaveaf.smallimdbapp.presentation.di.artist.ArtistSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.movie.MovieSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        MovieSubComponent::class,
        ArtistSubComponent::class,
        TvShowSubComponent::class
    ]
)
class ApplicationModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context
    }

}