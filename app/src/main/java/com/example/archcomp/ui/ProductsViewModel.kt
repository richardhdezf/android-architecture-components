package com.example.archcomp.ui

import androidx.lifecycle.*
import com.example.archcomp.data.Product
import com.example.archcomp.data.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel(private val productsRepository: ProductsRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            try {
                productsRepository.setup()
            } catch (error: Throwable) {
                throw Throwable("error al cargar lista", error)
            }
        }
    }

    fun getAll(): LiveData<List<Product>> = productsRepository.getAll()
}

class ProductsViewModelFactory(
    private val repository: ProductsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
