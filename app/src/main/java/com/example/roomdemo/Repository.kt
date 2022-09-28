package com.example.roomdemo

import androidx.lifecycle.LiveData

class Repository(private val productDao:ProductDao) {

    fun getAllItem(): LiveData<List<Product>> {
        return productDao.getAllItem()
    }
    suspend fun insert(product:Product):Long{
        return productDao.insertItem(product)
    }

    suspend fun delete(product: Product):Int{
        return productDao.deleteItem(product)
    }

    suspend fun deleteAll():Int{
        return productDao.deleteAll()
    }
}