package com.bikolpo.service

import com.bikolpo.model.AlternativesResponseItem
import com.bikolpo.model.CategoriesResponseItem
import com.bikolpo.utils.Constant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface APIService {

    @GET("categories")
    suspend fun getCategories(): Response<List<CategoriesResponseItem>>

    @GET("alternatives")
    suspend fun getAlternatives(): Response<List<AlternativesResponseItem>>

}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

object Network {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiService = retrofit.create(APIService::class.java)
}