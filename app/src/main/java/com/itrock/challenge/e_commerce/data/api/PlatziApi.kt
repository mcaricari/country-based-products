package com.itrock.challenge.e_commerce.data.api

import com.itrock.challenge.e_commerce.data.model.PlatziProductDto
import com.itrock.challenge.e_commerce.domain.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface PlatziApi {
    @GET("products")
    suspend fun getProducts(): List<PlatziProductDto>

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): PlatziProductDto
}