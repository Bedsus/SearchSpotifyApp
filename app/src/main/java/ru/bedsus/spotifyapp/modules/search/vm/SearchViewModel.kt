package ru.bedsus.spotifyapp.modules.search.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.data.search.models.ListItem
import ru.bedsus.spotifyapp.data.search.models.SearchType
import ru.bedsus.spotifyapp.modules.search.repository.SearchRepository
import ru.bedsus.spotifyapp.modules.search.user_case.SearchUserCases

class SearchViewModel(
    private val repository: SearchRepository
) : ViewModel() {

    val fromYear = MutableLiveData<String>(null)
    val toYear = MutableLiveData<String>(null)
    val genre = MutableLiveData<String>(null)
    val type = MutableLiveData<Set<SearchType>>(setOf())

    val searchLiveData: LiveData<ResultRequest<List<ListItem>>>
        get() = _searchLiveData
    private val _searchLiveData = MutableLiveData<ResultRequest<List<ListItem>>>()

    fun search(query: CharSequence) {
        if (query.isEmpty()) {
            _searchLiveData.value = ResultRequest.Success(listOf())
        }
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