package ru.bedsus.spotifyapp.modules.playlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.playlist_item.view.*
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem

class PlaylistAdapter : ListAdapter<PlaylistItem, PlaylistAdapter.ViewHolder>(PlaylistDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PlaylistItem) {
            itemView.vNamePlaylist.text = item.name
            if (item.image?.url?.isNotEmpty() == true) {
                Picasso.get()
                    .load(item.image.url)
                    .fit()
                    .into(itemView.vImagePlaylist)
            }
        }
    }
}