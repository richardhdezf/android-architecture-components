/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.archcomp.data.local

import androidx.paging.PagingSource
import androidx.room.*
import com.example.archcomp.data.Favorite

@Dao
interface FavoritesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Favorite)

    @Delete
    suspend fun delete(item: Favorite)

    @Query("SELECT * FROM favorite_table ORDER BY title ASC")
    fun getAll(): PagingSource<Int, Favorite>
}
