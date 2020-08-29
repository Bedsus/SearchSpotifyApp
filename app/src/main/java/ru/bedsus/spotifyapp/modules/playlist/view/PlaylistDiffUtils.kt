package ru.bedsus.spotifyapp.modules.playlist.view

import androidx.recyclerview.widget.DiffUtil
import ru.bedsus.spotifyapp.modules.playlist.models.PlaylistItem

object PlaylistDiffUtils : DiffUtil.ItemCallback<PlaylistItem>() {
    override fun areItemsTheSame(oldItem: PlaylistItem, newItem: PlaylistItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PlaylistItem, newItem: PlaylistItem): Boolean {
        return oldItem == newItem
    }
}