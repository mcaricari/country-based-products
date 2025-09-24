package com.itrock.challenge.e_commerce.data.api

import com.itrock.challenge.e_commerce.data.model.FakeProductDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Defines the contract for a fake API providing product data.
 */
interface FakeApi {
    /**
     * Retrieves a list of all fake products.
     *
     * @return A list of [FakeProductDto] objects.
     */
    @GET("products")
    suspend fun getProducts(): List<FakeProductDto>

    /**
     * Retrieves a specific fake product by its unique identifier.
     *
     * @param id The unique identifier of the fake product to retrieve.
     * @return The [FakeProductDto] matching the given [id], or null if not found.
     */
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): FakeProductDto
}