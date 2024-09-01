package com.bikolpo.service

import com.bikolpo.utils.Constant
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface BrandService {
    @GET("brands")
    suspend fun getIndianBrands(): Response<String>
}

object BrandServiceNetwork {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val brandsService: BrandService = retrofit.create(BrandService::class.java)

}