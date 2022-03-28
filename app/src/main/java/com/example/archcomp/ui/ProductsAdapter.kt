package com.example.archcomp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.archcomp.data.Product
import com.example.archcomp.databinding.ProductListTileBinding

class ProductsAdapter(private val itemListener: ProductListener) :
    ListAdapter<Product, ProductsAdapter.ProductViewHolder>(PRODUCT_COMPARATOR) {

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
        holder.bind(getItem(position), itemListener)
    }

    class ProductViewHolder(
        private val binding: ProductListTileBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product, listener: ProductListener) {
            binding.apply {
                this.item = item
            }
            itemView.setOnClickListener {
                listener.onClick(item)
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
