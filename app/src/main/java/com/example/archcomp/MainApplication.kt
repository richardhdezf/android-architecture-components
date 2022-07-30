package com.example.archcomp

import android.app.Application
import com.example.archcomp.data.FavoritesDefaultRepository
import com.example.archcomp.data.FavoritesRepository
import com.example.archcomp.data.ProductsDefaultRepository
import com.example.archcomp.data.ProductsRepository
import com.example.archcomp.data.local.ApplicationDatabase
import com.example.archcomp.data.local.FavoritesLocalDataSource
import com.example.archcomp.data.local.ProductsLocalDataSource
import com.example.archcomp.data.remote.ProductsRemoteDataSource
import com.example.archcomp.data.remote.ProductsApi

class MainApplication : Application() {
    companion object {
        lateinit var productsRepository: ProductsRepository
        lateinit var favoritesRepository: FavoritesRepository
    }

    override fun onCreate() {
        super.onCreate()
        val database =
            ApplicationDatabase.getDatabase(this)

        val productsLocalDataSource = ProductsLocalDataSource(database.productsDao())
        val productsRemoteDataSource = ProductsRemoteDataSource(ProductsApi.service)
        productsRepository =
            ProductsDefaultRepository(productsLocalDataSource, productsRemoteDataSource)

        val favoritesLocalDataSource = FavoritesLocalDataSource(database.favoritesDao())
        favoritesRepository = FavoritesDefaultRepository(favoritesLocalDataSource)
    }
}
