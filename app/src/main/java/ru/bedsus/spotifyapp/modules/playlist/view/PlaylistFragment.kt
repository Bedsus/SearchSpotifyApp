package ru.bedsus.spotifyapp.modules.playlist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.bedsus.core.repository.ResultRequest
import ru.bedsus.core.viewbinding.viewBinding
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.databinding.PlaylistFragmentBinding
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem
import ru.bedsus.spotifyapp.modules.playlist.vm.PlaylistViewModel
import timber.log.Timber

class PlaylistFragment : Fragment(R.layout.playlist_fragment) {

    private val viewModel by viewModel<PlaylistViewModel>()
    private var adapter: PlaylistAdapter? = null

    private val binding by viewBinding(PlaylistFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.vPlaylistRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PlaylistAdapter()
            addItemDecoration(
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            )
            adapter = adapter
        }
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
        binding.vLoading.show()
    }

    private fun hideLoading() {
        binding.vLoading.hide()
    }
}