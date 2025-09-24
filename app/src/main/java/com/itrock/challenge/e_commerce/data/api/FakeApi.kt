package com.itrock.challenge.e_commerce.data.api

import com.itrock.challenge.e_commerce.data.model.FakeProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FakeApi {
    @GET("products")
    suspend fun getProducts(): List<FakeProductDto>

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): FakeProductDto
}