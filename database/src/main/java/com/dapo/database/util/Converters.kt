package com.dapo.database.util

import androidx.room.TypeConverter
import com.dapo.remote.model.Source
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SourceConverter {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val adapter = moshi.adapter(Source::class.java)

    @TypeConverter
    fun sourceToString(source: Source): String {
        return adapter.toJson(source)
    }

    @TypeConverter
    fun stringToSource(string: String): Source? {
        return adapter.fromJson(string)
    }
}
