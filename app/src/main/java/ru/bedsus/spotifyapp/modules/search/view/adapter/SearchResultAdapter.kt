package ru.bedsus.spotifyapp.modules.search.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_list_item.view.*
import kotlinx.android.synthetic.main.artist_list_item.view.*
import kotlinx.android.synthetic.main.track_list_item.view.*
import ru.bedsus.spotifyapp.R
import ru.bedsus.spotifyapp.modules.search.models.SearchType
import ru.bedsus.spotifyapp.modules.search.models.SearchItem

class SearchResultAdapter : ListAdapter<SearchItem, SearchResultAdapter.ViewHolder>(SearchItemDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (SearchType.values()[viewType]) {
            SearchType.ALBUM -> AlbumViewHolder(getLayoutItems(R.layout.album_list_item, parent))
            SearchType.ARTIST -> ArtistViewHolder(getLayoutItems(R.layout.artist_list_item, parent))
            SearchType.TRACK -> TrackViewHolder(getLayoutItems(R.layout.track_list_item, parent))
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).type.ordinal

    private fun getLayoutItems(layoutId: Int, parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.firstText?.text = item.firstText
        holder.secondText?.text = item.secondText
        if (holder.imageView != null && item.image.isNotEmpty()) {
            Picasso.get()
                    .load(item.image)
                    .fit()
                    .into(holder.imageView)
        }
    }

    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract val firstText: TextView?
        abstract val secondText: TextView?
        abstract val imageView: ImageView?
    }

    class AlbumViewHolder(itemView: View): ViewHolder(itemView) {
        override val firstText: TextView
            get() = itemView.vAlbumName
        override val secondText: TextView
            get() = itemView.vArtistNameByAlbum
        override val imageView: ImageView
            get() = itemView.vAlbumImage

    }

    class ArtistViewHolder(itemView: View): ViewHolder(itemView) {
        override val firstText: TextView
            get() = itemView.vArtistName
        override val secondText: TextView? = null
        override val imageView: ImageView
            get() = itemView.vArtistImage
    }

    class TrackViewHolder(itemView: View): ViewHolder(itemView) {
        override val firstText: TextView
            get() = itemView.vTrackName
        override val secondText: TextView
            get() = itemView.vArtistNameByTrack
        override val imageView: ImageView
            get() = itemView.vTrackImage
    }
}