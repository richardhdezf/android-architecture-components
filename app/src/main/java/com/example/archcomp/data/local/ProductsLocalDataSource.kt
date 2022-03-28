package com.example.archcomp.data.local

import androidx.lifecycle.LiveData
import com.example.archcomp.data.Product

class ProductsLocalDataSource(private val productsDao: ProductsDao) {
    suspend fun insertAll(itemList: List<Product>) = productsDao.insertAll(itemList)

    suspend fun deleteAll() = productsDao.deleteAll()

    fun getAll(): LiveData<List<Product>> = productsDao.getAll()
}
