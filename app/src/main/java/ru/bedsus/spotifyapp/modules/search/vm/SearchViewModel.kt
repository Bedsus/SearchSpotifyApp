package ru.bedsus.spotifyapp.modules.search.vm

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.modules.search.models.SearchResult
import ru.bedsus.spotifyapp.modules.search.models.SearchType
import ru.bedsus.spotifyapp.modules.search.repository.SearchRepository
import ru.bedsus.spotifyapp.modules.search.user_case.SearchUserCases
import ru.bedsus.spotifyapp.modules.search.vm.models.SearchItem

class SearchViewModel(
    private val repository: SearchRepository
) : ViewModel() {

    val fromYear = MutableLiveData<String>(null)
    val toYear = MutableLiveData<String>(null)
    val genre = MutableLiveData<String>(null)
    val type = MutableLiveData<Set<SearchType>>(setOf())

    val searchLiveData: LiveData<ResultRequest<List<SearchItem>>>
        get() = _searchLiveData
    private val _searchLiveData = MutableLiveData<ResultRequest<List<SearchItem>>>()

    fun search(query: CharSequence) {
        val resultQuery = SearchUserCases.generateSearchQuery(
            query = query.toString().trim(),
            fromYear = fromYear.value ?: "",
            toYear = toYear.value ?: "",
            genre = genre.value ?: "",
        )
        val types = if (type.value != null && type.value!!.isNotEmpty())
            type.value!! else SearchType.values().toSet()
        val typeString = types.joinToString(",") { it.value }
        viewModelScope.launch {
            _searchLiveData.value = ResultRequest.Loading
            when (val result = repository.search(resultQuery, typeString)) {
                is ResultRequest.Success -> {
                    val searchItems = SearchUserCases.createSearchItemList(result.data)
                    _searchLiveData.value = ResultRequest.Success(searchItems)
                }
                is ResultRequest.Error ->
                    _searchLiveData.value = ResultRequest.Error(result.exception)
            }
        }
    }
}