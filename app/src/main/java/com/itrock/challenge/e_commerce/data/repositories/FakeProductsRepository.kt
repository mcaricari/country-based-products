package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.data.api.FakeApi
import com.itrock.challenge.e_commerce.data.model.toDomain
import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import com.itrock.challenge.e_commerce.domain.model.Product
import javax.inject.Inject

/**
 * Implements [ProductsRepository] to provide fake product data.
 * This repository interacts with the [FakeApi] to get raw fake product data.
 *
 * @param api The [FakeApi] instance used for fetching fake data.
 */
class FakeProductsRepository
@Inject constructor(private val api: FakeApi) : ProductsRepository {

    /**
     * Retrieves a list of all fake products from the [FakeApi] and maps them to domain models.
     *
     * @return A list of [Product] objects.
     */
    override suspend fun getProducts(): List<Product> = api.getProducts().map { it.toDomain() }

    /**
     * Retrieves a specific fake product by its ID from the [FakeApi] and maps it to a domain model.
     *
     * @param id The unique identifier of the fake product to retrieve.
     * @return The corresponding [Product] object.
     */
    override suspend fun getProduct(id: Int): Product = api.getProduct(id).toDomain()
}
