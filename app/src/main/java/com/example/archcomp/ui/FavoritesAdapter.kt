package com.example.archcomp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.archcomp.data.Favorite
import com.example.archcomp.databinding.FavoriteListTileBinding

class FavoritesAdapter(private val itemListener: FavoriteListener) :
    PagingDataAdapter<Favorite, FavoritesAdapter.FavoriteViewHolder>(FAVORITE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            FavoriteListTileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position)!!, itemListener)
    }

    class FavoriteViewHolder(
        private val binding: FavoriteListTileBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Favorite, listener: FavoriteListener) {
            binding.apply {
                this.item = item
            }
            itemView.setOnClickListener {
                listener.onDelete(item)
            }
        }
    }

    companion object {
        private val FAVORITE_COMPARATOR = object : DiffUtil.ItemCallback<Favorite>() {
            override fun areItemsTheSame(
                oldItem: Favorite,
                newItem: Favorite
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Favorite,
                newItem: Favorite
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
