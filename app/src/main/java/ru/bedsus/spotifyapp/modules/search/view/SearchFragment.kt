package ru.bedsus.spotifyapp.modules.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.search_fragment.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.modules.search.vm.SearchViewModel
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment() {

    private var disposablies = CompositeDisposable()
    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.search_fragment, container, false)
        disposablies.add(
            view.vSearchEditText.textChanges()
                .debounce(INPUT_PROCESSING_INTERVAL, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ viewModel.search(it) }, {
                    Timber.e(it,"Ошибка считывания")
                })
        )
        viewModel.searchLiveData.observe(viewLifecycleOwner) { result ->
            view.vResultText.text = when (result) {
                is ResultRequest.Success -> """
tracks: 
${result.data.tracks.joinToString("\n") { "${it.artists[0].name} - ${it.name}" }}
albums: 
${result.data.albums.joinToString("\n") { "${it.artists[0].name} - ${it.name}" }}
artists: 
${result.data.artists.joinToString("\n") { it.name }}
                """.trimIndent()
                is ResultRequest.Error -> result.exception.localizedMessage
                ResultRequest.Loading -> "loading..."
            }
        }
        return view
    }

    override fun onDestroy() {
        disposablies.dispose()
        super.onDestroy()
    }

    companion object {
        const val INPUT_PROCESSING_INTERVAL = 200L
    }
}