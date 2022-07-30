package com.example.archcomp.ui

import androidx.lifecycle.*
import androidx.paging.*
import com.example.archcomp.data.Favorite
import com.example.archcomp.data.FavoritesRepository
import com.example.archcomp.data.Product
import com.example.archcomp.data.ProductsRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductsViewModel(
    private val productsRepository: ProductsRepository,
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {
    init {
        viewModelScope.launch {
            try {
                productsRepository.setup()
            } catch (error: Throwable) {
                throw Throwable("error al cargar lista", error)
            }
        }
    }

    fun insertFavorite(item: Product) {
        viewModelScope.launch {
            val favorite = Favorite(item.image, item.price, item.id, item.title, item.category)
            favoritesRepository.insert(favorite)
        }
    }

    fun deleteFavorite(item: Favorite) {
        viewModelScope.launch {
            favoritesRepository.delete(item)
        }
    }

    fun getAll(): LiveData<List<Product>> = productsRepository.getAll()

    fun getAllFavorites(): Flow<PagingData<Favorite>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            maxSize = 100
        )
    ) {
        favoritesRepository.getAll()
    }.flow
        .map { pagingData ->
            pagingData
                .filter { favorite -> favorite.price >= 20 }
        }
        .cachedIn(viewModelScope)
}

class ProductsViewModelFactory(
    private val productsRepository: ProductsRepository,
    private val favoritesRepository: FavoritesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductsViewModel(productsRepository, favoritesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
