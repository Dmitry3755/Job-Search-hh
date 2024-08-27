package com.example.data.room.converters

import androidx.room.TypeConverter
import com.google.gson.Gson

interface GsonConverter {
    var gson: Gson
        get() = Gson()
        set(value) {}
}