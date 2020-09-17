package ru.bedsus.core.di

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import org.koin.dsl.module
import ru.bedsus.core.BuildConfig
import ru.bedsus.core.network.NetworkService
import ru.bedsus.core.network.NetworkServiceImpl
import ru.bedsus.core.token.TokenManager
import ru.bedsus.core.token.TokenManagerImpl

val coreModule = module {
    single<SharedPreferences> {
        PreferenceManager.getDefaultSharedPreferences(get())
    }
    single<TokenManager> { TokenManagerImpl(get()) }
    single<NetworkService>{ NetworkServiceImpl(BuildConfig.SERVER_URL, get()) }
}