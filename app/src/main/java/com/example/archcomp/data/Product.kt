package com.example.archcomp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

@Entity(tableName = "product_table")
data class Product(
    @ColumnInfo(name = "image")
    @field:SerializedName("image")
    val image: String,

    @ColumnInfo(name = "price")
    @field:SerializedName("price")
    val price: Double,

    @ColumnInfo(name = "description")
    @field:SerializedName("description")
    val description: String,

    @PrimaryKey @ColumnInfo(name = "id")
    @field:SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "title")
    @field:SerializedName("title")
    val title: String,

    @ColumnInfo(name = "category")
    @field:SerializedName("category")
    val category: String
) {
    @Ignore
    val formattedPrice: String = "${DecimalFormat("#,###.##").format(price)} CLP"
}