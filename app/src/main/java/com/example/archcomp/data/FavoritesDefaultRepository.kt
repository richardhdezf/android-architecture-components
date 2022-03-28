package com.example.archcomp.data

import androidx.paging.PagingSource
import com.example.archcomp.data.local.FavoritesLocalDataSource

class FavoritesDefaultRepository(
    private val localDataSource: FavoritesLocalDataSource
) : FavoritesRepository {
    override suspend fun insert(item: Favorite) = localDataSource.insert(item)

    override suspend fun delete(item: Favorite) = localDataSource.delete(item)

    override fun getAll(): PagingSource<Int, Favorite> = localDataSource.getAll()
}
