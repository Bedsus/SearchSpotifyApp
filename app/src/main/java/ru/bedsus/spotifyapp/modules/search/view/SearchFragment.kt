package ru.bedsus.spotifyapp.modules.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.search_fragment.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.modules.search.view.adapter.SearchResultAdapter
import ru.bedsus.spotifyapp.modules.search.vm.SearchViewModel
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment() {

    private var disposablies = CompositeDisposable()
    private val viewModel: SearchViewModel by viewModel()
    private var adapter: SearchResultAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.search_fragment, container, false)
        adapter = SearchResultAdapter()
        view.vSearchItemList.layoutManager = LinearLayoutManager(requireContext())
        view.vSearchItemList.adapter = adapter
        disposablies.add(
            view.vSearchEditText.textChanges()
                .debounce(INPUT_PROCESSING_INTERVAL, TimeUnit.MILLISECONDS)
                .subscribe({ viewModel.search(it) }, {
                    Timber.e(it,"Ошибка считывания")
                })
        )
        viewModel.searchLiveData.observe(viewLifecycleOwner) { result ->
            view.vLoading.hide()
            when (result) {
                is ResultRequest.Success -> {
                    adapter?.submitList(result.data)
                }
                is ResultRequest.Error -> {
                    Timber.e(result.exception)
                }
                ResultRequest.Loading -> view.vLoading.show()
            }
        }
        return view
    }

    override fun onDestroy() {
        disposablies.dispose()
        super.onDestroy()
    }

    companion object {
        const val INPUT_PROCESSING_INTERVAL = 150L
    }
}