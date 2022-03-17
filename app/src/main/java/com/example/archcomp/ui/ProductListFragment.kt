package com.example.archcomp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.archcomp.MainApplication
import com.example.archcomp.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding
    private val productsViewModel: ProductsViewModel by viewModels {
        ProductsViewModelFactory(MainApplication.productsRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val productListAdapter = ProductListAdapter()
        val productListView = binding.productListView
        productListView.adapter = productListAdapter

        productsViewModel
            .getAll()
            .observe(viewLifecycleOwner) { itemList ->
                productListAdapter.submitList(itemList)
            }

        return root
    }
}