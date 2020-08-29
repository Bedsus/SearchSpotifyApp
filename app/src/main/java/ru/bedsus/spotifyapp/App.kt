package ru.bedsus.spotifyapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.bedsus.core.di.coreModule
import ru.bedsus.spotifyapp.di.appModule
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                coreModule, appModule
            )
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}