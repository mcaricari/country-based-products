package com.itrock.challenge.e_commerce.domain.interfaces

import com.itrock.challenge.e_commerce.domain.model.Product

/**
 * Defines the contract for accessing product data.
 * Implementations of this interface are responsible for fetching product information.
 */
interface ProductsRepository {

    /**
     * Retrieves a list of available products.
     *
     * @return A list of [Product] objects. Can be an empty list if no products are available.
     */
    suspend fun getProducts(): List<Product>

    /**
     * Retrieves a specific product by its unique identifier.
     * Implementations should handle cases where the product is not found,
     * typically by throwing an exception.
     *
     * @param id The unique identifier of the product to retrieve.
     * @return The [Product] object matching the given [id].
     */
    suspend fun getProduct(id: Int): Product
}
