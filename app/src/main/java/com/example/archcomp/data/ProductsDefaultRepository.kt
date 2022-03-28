package com.example.archcomp.data

import androidx.lifecycle.LiveData
import com.example.archcomp.data.local.ProductsLocalDataSource
import com.example.archcomp.data.remote.ProductsRemoteDataSource

class ProductsDefaultRepository(
    private val localDataSource: ProductsLocalDataSource,
    private val remoteDataSource: ProductsRemoteDataSource
) : ProductsRepository {
    override suspend fun setup() {
        val itemList = remoteDataSource.getAll()
        localDataSource.deleteAll()
        localDataSource.insertAll(itemList)
    }

    override fun getAll(): LiveData<List<Product>> = localDataSource.getAll()
}
