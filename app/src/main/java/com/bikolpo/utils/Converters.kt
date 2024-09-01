package com.bikolpo.utils

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromListToString(list: List<Int>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun fromStringToList(value: String?): List<Int>? {
        return value?.split(",")?.map { it.toInt() }
    }
}