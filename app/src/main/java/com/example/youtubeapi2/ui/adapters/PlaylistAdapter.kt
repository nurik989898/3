package com.example.youtubeapi2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi2.databinding.ItemPlaylistBinding
import com.example.youtubeapi2.di.extensions.load
import com.example.youtubeapi2.model.Item
import com.example.youtubeapi2.model.Playlist

class PlaylistAdapter(private var list: Playlist) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        list.items.get(position).let { holder.bind(it) }

    }

    override fun getItemCount(): Int {
        return list.items.size ?: 0
    }


    class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(playlist: Item) {
            binding.ivPlaylist.load(playlist.snippet.thumbnails.medium.url)
            binding.tvPlaylistTitle.text = playlist.snippet.title
            binding.tvVideoCounter.text = playlist.contentDetails.itemCount.toString()
        }


    }
}