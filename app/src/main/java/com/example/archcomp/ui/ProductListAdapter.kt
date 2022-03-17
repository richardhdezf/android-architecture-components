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
import com.example.archcomp.data.Product
import com.example.archcomp.databinding.ProductListTileBinding

class ProductListAdapter :
    ListAdapter<Product, ProductListAdapter.ProductViewHolder>(PRODUCT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductListTileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductViewHolder(
        private val binding: ProductListTileBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            binding.apply {
                this.item = item
            }
        }
    }

    companion object {
        private val PRODUCT_COMPARATOR = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
