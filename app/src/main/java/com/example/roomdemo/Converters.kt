package com.example.roomdemo

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.w3c.dom.Comment
import java.util.*

class Converters {

    @TypeConverter
    fun dateToLong(value:Date):Long{
        return value.time
    }

    @TypeConverter
    fun longToDate(value:Long):Date{
        return Date(value)
    }

    @TypeConverter
    fun productListToString(product: List<ProductItem>):String{
        val gson= Gson()
        val type = object : TypeToken<List<ProductItem>>() {}.type
        return gson.toJson(product, type)

    }

    @TypeConverter
    fun stringToProductList(productString:String):List<ProductItem>{
        val gson = Gson()
        val type = object : TypeToken<List<ProductItem>>() {}.type
        return gson.fromJson(productString, type)
    }
}