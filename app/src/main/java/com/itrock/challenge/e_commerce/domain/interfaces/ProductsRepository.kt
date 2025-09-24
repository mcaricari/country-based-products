package com.itrock.challenge.e_commerce.domain.interfaces

import com.itrock.challenge.e_commerce.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProduct(id: Int): Product
}