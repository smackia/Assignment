package com.example.assignment.db.postdata

import androidx.room.TypeConverter
import com.example.assignment.data.model.D
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun listToJson(value: D?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String): D? =
        Gson().fromJson(value, object : TypeToken<D>() {}.type)

}