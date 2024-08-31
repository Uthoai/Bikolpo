package com.bikolpo.model


import com.squareup.moshi.Json
import android.support.annotation.Keep
import androidx.room.Entity

@Keep
@Entity(tableName = "categories")
data class CategoriesResponseItem(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "slug")
    val slug: String? = null
)

class CategoriesResponse : ArrayList<CategoriesResponseItem>()