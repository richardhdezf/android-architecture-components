/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.archcomp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.archcomp.data.Favorite
import com.example.archcomp.databinding.FavoriteListTileBinding

class FavoritesAdapter(private val itemListener: FavoriteListener) :
    ListAdapter<Favorite, FavoritesAdapter.FavoriteViewHolder>(FAVORITE_COMPARATOR) {

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
        holder.bind(getItem(position), itemListener)
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
