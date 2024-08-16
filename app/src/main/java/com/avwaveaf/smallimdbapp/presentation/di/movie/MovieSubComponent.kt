package com.avwaveaf.smallimdbapp.presentation.di.movie

import com.avwaveaf.smallimdbapp.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(
    modules = [
        MovieModule::class
    ]
)
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():MovieSubComponent
    }
}