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
package com.example.archcomp.data

import androidx.lifecycle.LiveData
import com.example.archcomp.data.local.FavoritesLocalDataSource

class FavoritesDefaultRepository(
    private val localDataSource: FavoritesLocalDataSource
) : FavoritesRepository {
    override suspend fun insert(item: Favorite) = localDataSource.insert(item)

    override suspend fun delete(item: Favorite) = localDataSource.delete(item)

    override fun getAll(): LiveData<List<Favorite>> = localDataSource.getAll()
}
