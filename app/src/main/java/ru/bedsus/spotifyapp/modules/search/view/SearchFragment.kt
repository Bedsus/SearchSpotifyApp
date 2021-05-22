package ru.bedsus.spotifyapp.modules.search.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.core.viewbinding.viewBinding
import ru.bedsus.spotifyapp.databinding.SearchFragmentBinding
import ru.bedsus.spotifyapp.modules.search.view.adapter.SearchResultAdapter
import ru.bedsus.spotifyapp.modules.search.vm.SearchViewModel
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment() {

    private var disposablies = CompositeDisposable()
    private val viewModel: SearchViewModel by viewModel()
    private var adapter: SearchResultAdapter? = null

    private val binding by viewBinding(SearchFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = SearchResultAdapter()
        with(binding.vSearchItemList) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }

        binding.vSearchEditText.textChanges()
            .debounce(INPUT_PROCESSING_INTERVAL, TimeUnit.MILLISECONDS)
            .subscribe({ viewModel.search(it) }, {
                Timber.e(it,"Ошибка считывания")
            }).apply { disposablies.add(this) }

        viewModel.searchLiveData.observe(viewLifecycleOwner) { result ->
            binding.vLoading.hide()
            when (result) {
                is ResultRequest.Success -> {
                    adapter?.submitList(result.data)
                }
                is ResultRequest.Error -> {
                    Timber.e(result.exception)
                }
                ResultRequest.Loading -> binding.vLoading.show()
            }
        }
    }

    override fun onDestroy() {
        disposablies.dispose()
        super.onDestroy()
    }

    companion object {
        const val INPUT_PROCESSING_INTERVAL = 150L
    }
}