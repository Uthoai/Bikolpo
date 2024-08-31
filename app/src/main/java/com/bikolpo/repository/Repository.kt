package com.bikolpo.repository

import android.util.Log
import androidx.room.RoomDatabase
import com.bikolpo.database.LocalDatabase
import com.bikolpo.model.CategoriesResponse
import com.bikolpo.service.APIService
import com.bikolpo.service.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository(private val database: LocalDatabase) {

    suspend fun fetchCategories() {
        withContext(Dispatchers.IO){
            try {
                val response = Network.apiService.getCategories()
                if (response.isSuccessful) {
                    response.body()?.let { data ->
                        database.categoriesDao.insertCategories(data)
                    }
                } else {
                    // Handle error
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCategoriesFromDatabase() = database.categoriesDao.getCategoriesList()

}