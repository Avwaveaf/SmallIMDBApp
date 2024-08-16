package com.avwaveaf.smallimdbapp.presentation.di

import com.avwaveaf.smallimdbapp.presentation.di.artist.ArtistSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.movie.MovieSubComponent
import com.avwaveaf.smallimdbapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}