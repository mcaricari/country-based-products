package com.itrock.challenge.e_commerce.data.api

import com.itrock.challenge.e_commerce.data.model.PlatziProductDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Defines the contract for interacting with the Platzi Fake Store API.
 */
interface PlatziApi {
    /**
     * Retrieves a list of all products from the Platzi API.
     * This corresponds to the "products" endpoint.
     *
     * @return A list of [PlatziProductDto] objects.
     */
    @GET("products")
    suspend fun getProducts(): List<PlatziProductDto>

    /**
     * Retrieves a specific product by its unique identifier from the Platzi API.
     * This corresponds to the "products/{id}" endpoint.
     *
     * @param id The unique identifier of the product to retrieve, used in the URL path.
     * @return The [PlatziProductDto] matching the given [id].
     */
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): PlatziProductDto
}
