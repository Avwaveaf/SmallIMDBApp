package com.avwaveaf.smallimdbapp.presentation.di.artist

import com.avwaveaf.smallimdbapp.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(
    modules = [
        ArtistModule::class
    ]
)
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():ArtistSubComponent
    }
}