package ru.bedsus.core.di

import org.koin.dsl.module
import ru.bedsus.core.BuildConfig
import ru.bedsus.core.network.NetworkService
import ru.bedsus.core.network.NetworkServiceImpl

val coreModule = module {
    single<NetworkService>{ NetworkServiceImpl(BuildConfig.SERVER_URL) }
}