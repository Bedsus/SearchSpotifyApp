package ru.bedsus.spotifyapp.modules.followed.di

import org.koin.dsl.module
import ru.bedsus.spotifyapp.modules.followed.repository.FollowedRepository
import ru.bedsus.spotifyapp.modules.followed.repository.FollowedRepositoryImpl

val followedModule = module {
    single<FollowedRepository> { FollowedRepositoryImpl(get()) }
}