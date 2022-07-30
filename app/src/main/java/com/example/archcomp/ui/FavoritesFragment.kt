package com.example.archcomp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.archcomp.MainApplication
import com.example.archcomp.data.Favorite
import com.example.archcomp.databinding.FragmentFavoritesBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
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
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val favoriteListener = object : FavoriteListener {
            override fun onDelete(item: Favorite) {
                productsViewModel.deleteFavorite(item)
                Snackbar.make(root, "item deleted from favorites", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
        val favoritesAdapter = FavoritesAdapter(favoriteListener)
        val favoritesView = binding.favoritesView
        favoritesView.adapter = favoritesAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            productsViewModel
                .getAllFavorites().collectLatest { favoritesAdapter.submitData(it) }
        }

        return root
    }
}