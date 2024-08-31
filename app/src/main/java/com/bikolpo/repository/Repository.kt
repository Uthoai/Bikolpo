package com.bikolpo.repository

import com.bikolpo.database.LocalDatabase
import com.bikolpo.service.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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