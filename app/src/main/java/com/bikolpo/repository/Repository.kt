package com.bikolpo.repository

import com.bikolpo.model.CategoriesResponse
import com.bikolpo.service.APIService
import retrofit2.Response

class Repository(private val service: APIService) {

    suspend fun getCategories(): Response<CategoriesResponse> {
        return service.getCategories()
    }

}