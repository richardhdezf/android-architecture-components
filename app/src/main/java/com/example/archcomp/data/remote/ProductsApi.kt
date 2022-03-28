package com.example.archcomp.data.remote

import com.example.archcomp.data.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://fakestoreapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ProductsService {
    @GET("products")
    suspend fun getAll(): List<Product>
}

object ProductsApi {
    val service: ProductsService by lazy {
        retrofit.create(ProductsService::class.java)
    }
}
