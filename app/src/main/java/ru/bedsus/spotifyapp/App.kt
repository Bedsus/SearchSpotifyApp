package ru.bedsus.spotifyapp

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.bedsus.core.di.coreModule
import ru.bedsus.spotifyapp.modules.playlist.di.playlistModule
import ru.bedsus.spotifyapp.modules.search.di.searchModule
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                coreModule, playlistModule, searchModule
            )
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}