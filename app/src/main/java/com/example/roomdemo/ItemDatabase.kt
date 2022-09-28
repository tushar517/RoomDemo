package com.example.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class ItemDatabase:RoomDatabase() {
    abstract val productDao:ProductDao?

    companion object{

        private var INSTANCE : ItemDatabase? = null
        fun getInstance(context: Context):ItemDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        ItemDatabase::class.java,
                        "Product_Table"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}