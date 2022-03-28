package com.example.archcomp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.archcomp.data.Product

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(itemList: List<Product>)

    @Query("DELETE FROM product_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM product_table ORDER BY title ASC")
    fun getAll(): LiveData<List<Product>>
}
