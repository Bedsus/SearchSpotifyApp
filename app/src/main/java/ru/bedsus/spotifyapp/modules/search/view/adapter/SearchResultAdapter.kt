package ru.bedsus.spotifyapp.modules.search.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.bedsus.spotifyapp.databinding.AlbumListItemBinding
import ru.bedsus.spotifyapp.databinding.ArtistListItemBinding
import ru.bedsus.spotifyapp.databinding.TrackListItemBinding
import ru.bedsus.spotifyapp.data.search.models.SearchType
import ru.bedsus.spotifyapp.data.search.models.ListItem

class SearchResultAdapter : ListAdapter<ListItem, SearchResultAdapter.ViewHolder>(SearchItemDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (SearchType.values()[viewType]) {
            SearchType.ALBUM -> AlbumViewHolder(
                AlbumListItemBinding.inflate(layoutInflater, parent, false)
            )
            SearchType.ARTIST -> ArtistViewHolder(
                ArtistListItemBinding.inflate(layoutInflater, parent, false)
            )
            SearchType.TRACK -> TrackViewHolder(
                TrackListItemBinding.inflate(layoutInflater, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).type.ordinal

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

    class AlbumViewHolder(
       private val viewBinding: AlbumListItemBinding
    ): ViewHolder(viewBinding.root) {
        override val firstText: TextView
            get() = viewBinding.vAlbumName
        override val secondText: TextView
            get() = viewBinding.vArtistNameByAlbum
        override val imageView: ImageView
            get() = viewBinding.vAlbumImage

    }

    class ArtistViewHolder(
        private val viewBinding: ArtistListItemBinding
    ): ViewHolder(viewBinding.root) {
        override val firstText: TextView
            get() = viewBinding.vArtistName
        override val secondText: TextView? = null
        override val imageView: ImageView
            get() = viewBinding.vArtistImage
    }

    class TrackViewHolder(
       private val viewBinding: TrackListItemBinding
    ): ViewHolder(viewBinding.root) {
        override val firstText: TextView
            get() = viewBinding.vTrackName
        override val secondText: TextView
            get() = viewBinding.vArtistNameByTrack
        override val imageView: ImageView
            get() = viewBinding.vTrackImage
    }
}