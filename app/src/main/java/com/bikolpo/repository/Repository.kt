package com.bikolpo.repository

import com.bikolpo.database.LocalDatabase
import com.bikolpo.service.BrandServiceNetwork
import com.bikolpo.service.Network
import com.bikolpo.utils.parseBrandJsonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray

class Repository(private val database: LocalDatabase) {

    suspend fun fetchCategories() {
        withContext(Dispatchers.IO) {
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

    suspend fun fetchIndianBrands() {
        withContext(Dispatchers.IO) {
            try {
                val response = BrandServiceNetwork.brandsService.getIndianBrands()
                if (response.isSuccessful) {
                    response.body()?.let { data ->
                        val jsonResult = JSONArray(data)
                        val brandList = parseBrandJsonResult(jsonResult)
                        database.indianBrandsDao.insertIndianBrands(brandList)
                    }
                } else {
                    // Handle error
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getIndianBrandsFromDatabase() = database.indianBrandsDao.getIndianBrandsList()

}
