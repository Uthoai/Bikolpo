package com.bikolpo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bikolpo.model.CategoriesResponseItem

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoriesResponseItem>)

    @Query("SELECT * FROM categories")
    suspend fun getCategories(): List<CategoriesResponseItem>

}