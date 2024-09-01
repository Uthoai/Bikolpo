package com.bikolpo.model


import com.squareup.moshi.Json
import android.support.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "alternatives_table")
data class AlternativesResponseItem(
    @Json(name = "en_name")
    val enName: String? = null,
    @Json(name = "id")
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "name")
    val name: String? = null
)