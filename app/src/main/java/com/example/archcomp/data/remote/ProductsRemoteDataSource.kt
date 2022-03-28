package com.example.archcomp.data.remote

import com.example.archcomp.data.Product

class ProductsRemoteDataSource(private val productsService: ProductsService){
    suspend fun getAll(): List<Product> = productsService.getAll()
}
