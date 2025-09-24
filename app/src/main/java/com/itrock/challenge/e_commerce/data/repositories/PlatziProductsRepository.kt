package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.data.api.PlatziApi
import com.itrock.challenge.e_commerce.data.model.toDomain
import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import com.itrock.challenge.e_commerce.domain.model.Product
import javax.inject.Inject

/**
 * Implements [ProductsRepository] to fetch product data from the Platzi API.
 * This repository interacts with the [PlatziApi] to get raw product data and
 * then maps it to the domain [Product] model.
 *
 * @param api The [PlatziApi] instance used for network operations.
 */
class PlatziProductsRepository
@Inject constructor(private val api: PlatziApi) : ProductsRepository {

    /**
     * Retrieves a list of all products from the Platzi API and maps them to domain models.
     *
     * @return A list of [Product] objects.
     */
    override suspend fun getProducts(): List<Product> = api.getProducts().map { it.toDomain() }

    /**
     * Retrieves a specific product by its ID from the Platzi API and maps it to a domain model.
     *
     * @param id The unique identifier of the product to retrieve.
     * @return The corresponding [Product] object.
     */
    override suspend fun getProduct(id: Int): Product = api.getProduct(id).toDomain()
}
