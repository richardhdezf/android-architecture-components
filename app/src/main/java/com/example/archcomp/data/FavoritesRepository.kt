package com.example.archcomp.data

import androidx.paging.PagingSource

interface FavoritesRepository {
    suspend fun insert(item: Favorite)
    suspend fun delete(item: Favorite)
    fun getAll(): PagingSource<Int, Favorite>
}
