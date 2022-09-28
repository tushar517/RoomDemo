package com.example.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "Product_Table")
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var ID:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "listQty")
    var listQty:Int,

    @ColumnInfo(name = "listItem")
    var listItem:List<ProductItem>,

    var dateCreated:Date

):Serializable