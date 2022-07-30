package com.example.archcomp.ui

import com.example.archcomp.data.Favorite

interface FavoriteListener {
    fun onDelete(item: Favorite)
}