package ru.bedsus.spotifyapp.modules.playlist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.playlist_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem
import ru.bedsus.spotifyapp.modules.playlist.vm.PlaylistViewModel
import timber.log.Timber

class PlaylistFragment : Fragment(R.layout.playlist_fragment) {

    private val viewModel by viewModel<PlaylistViewModel>()
    private var adapter: PlaylistAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vPlaylistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = PlaylistAdapter()
        vPlaylistRecyclerView.adapter = adapter
        viewModel.playlistLiveData.observe(viewLifecycleOwner) {
            handleRequest(it)
        }
    }

    private fun handleRequest(result: ResultRequest<List<PlaylistItem>>) {
        hideLoading()
        when (result) {
            is ResultRequest.Success -> showPlaylists(result.data)
            is ResultRequest.Error -> handleError(result.exception)
            ResultRequest.Loading -> showLoading()
        }
    }

    private fun showPlaylists(list: List<PlaylistItem>) {
        adapter?.submitList(list)
    }

    private fun handleError(ex: Exception) {
        Timber.e(ex)
    }

    private fun showLoading() {

    }

    private fun hideLoading() {

    }
}