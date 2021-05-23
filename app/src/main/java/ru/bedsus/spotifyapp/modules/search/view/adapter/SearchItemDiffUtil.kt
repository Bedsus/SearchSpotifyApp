package ru.bedsus.spotifyapp.modules.search.view.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.bedsus.spotifyapp.data.search.models.ListItem

object SearchItemDiffUtil : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }
}