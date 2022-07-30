package com.example.archcomp.ui

import com.example.archcomp.data.Product

interface ProductListener {
    fun onClick(item: Product)
}