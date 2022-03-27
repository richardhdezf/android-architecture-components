package com.example.archcomp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.archcomp.MainApplication
import com.example.archcomp.data.Product
import com.example.archcomp.databinding.FragmentProductsBinding
import com.google.android.material.snackbar.Snackbar

class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private val productsViewModel: ProductsViewModel by viewModels {
        ProductsViewModelFactory(
            MainApplication.productsRepository,
            MainApplication.favoritesRepository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val productListener = object : ProductListener {
            override fun onClick(item: Product) {
                productsViewModel.insertFavorite(item)
                Snackbar.make(root, "item added to favorites", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
        val productsAdapter = ProductsAdapter(productListener)
        val productsView = binding.productsView

        productsView.adapter = productsAdapter

        productsViewModel
            .getAll()
            .observe(viewLifecycleOwner) { itemList ->
                productsAdapter.submitList(itemList)
            }

        return root
    }
}