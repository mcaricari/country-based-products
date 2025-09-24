package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.data.api.FakeApi
import com.itrock.challenge.e_commerce.data.model.toDomain
import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import com.itrock.challenge.e_commerce.domain.model.Product
import javax.inject.Inject

class FakeProductsRepository
@Inject constructor(private val api: FakeApi) : ProductsRepository {
    override suspend fun getProducts(): List<Product> = api.getProducts().map { it.toDomain() }

    override suspend fun getProduct(id: Int): Product = api.getProduct(id).toDomain()
}