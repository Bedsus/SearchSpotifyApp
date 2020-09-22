package ru.bedsus.spotifyapp.modules.search.view.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.bedsus.spotifyapp.modules.search.models.SearchItem

object SearchItemDiffUtil : DiffUtil.ItemCallback<SearchItem>() {
    override fun areItemsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
        return oldItem == newItem
    }
}