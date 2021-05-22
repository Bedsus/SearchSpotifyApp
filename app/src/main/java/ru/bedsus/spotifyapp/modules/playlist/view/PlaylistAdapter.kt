package ru.bedsus.spotifyapp.modules.playlist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.bedsus.spotifyapp.databinding.PlaylistItemBinding
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem

class PlaylistAdapter : ListAdapter<PlaylistItem, PlaylistAdapter.ViewHolder>(PlaylistDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
       private val viewBinding: PlaylistItemBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: PlaylistItem) = with(viewBinding) {
            vNamePlaylist.text = item.name
            if (item.image?.url?.isNotEmpty() == true) {
                Picasso.get()
                    .load(item.image.url)
                    .fit()
                    .into(vImagePlaylist)
            }
        }
    }
}