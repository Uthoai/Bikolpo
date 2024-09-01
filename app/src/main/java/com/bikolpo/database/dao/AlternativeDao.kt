package com.bikolpo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bikolpo.model.AlternativesResponseItem

@Dao
interface AlternativeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlternative(alternatives: List<AlternativesResponseItem>)

    @Query("SELECT * FROM categories")
    fun getAlternativeList(): LiveData<List<AlternativesResponseItem>>

}