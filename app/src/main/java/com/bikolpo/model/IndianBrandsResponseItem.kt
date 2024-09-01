package com.bikolpo.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "indian_brands")
data class IndianBrandsResponseItem(
    val alternatives: String? = null,
    val categories: String? = null,
    val enName: String? = null,
    val image: String? = null,
    @PrimaryKey(autoGenerate = false)
    val id: Long? = null,
    val name: String? = null
): Parcelable


