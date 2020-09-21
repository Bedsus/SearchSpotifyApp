package ru.bedsus.spotifyapp.modules.search.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.bedsus.core.network.NetworkService
import ru.bedsus.spotifyapp.modules.search.endpoints.SearchApiService
import ru.bedsus.spotifyapp.modules.search.repository.SearchRepository
import ru.bedsus.spotifyapp.modules.search.repository.SearchRepositoryImpl
import ru.bedsus.spotifyapp.modules.search.vm.SearchViewModel

val searchModule = module {
    single { getSearchApiService(get()) }
    single<SearchRepository> { SearchRepositoryImpl(get()) }
    viewModel { SearchViewModel(get()) }
}

private fun getSearchApiService(service: NetworkService): SearchApiService {
    return service.create(SearchApiService::class.java)
}