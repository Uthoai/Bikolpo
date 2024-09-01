package com.bikolpo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bikolpo.model.IndianBrandsResponseItem

@Dao
interface IndianBrandsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIndianBrands(brands: List<IndianBrandsResponseItem>)

    @Query("SELECT * FROM indian_brands")
    fun getIndianBrandsList(): LiveData<List<IndianBrandsResponseItem>>

}