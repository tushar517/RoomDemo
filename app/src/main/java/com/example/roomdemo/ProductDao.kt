package com.example.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {

    @Insert
    suspend fun insertItem(user: Product):Long

    @Delete
    suspend fun deleteItem(user: Product):Int

    @Query("Select * from product_table")
    fun getAllItem(): LiveData<List<Product>>

    @Query("Delete From product_table")
    suspend fun deleteAll():Int

}