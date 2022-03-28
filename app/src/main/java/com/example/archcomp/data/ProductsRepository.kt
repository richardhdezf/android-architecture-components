package com.example.archcomp.data

import androidx.lifecycle.LiveData

interface ProductsRepository {
    suspend fun setup()
//    suspend fun insertAll(itemList: List<Product>)
    fun getAll(): LiveData<List<Product>>
}
