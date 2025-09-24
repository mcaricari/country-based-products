package com.itrock.challenge.e_commerce.domain.model

/**
 * Represents a product in the e-commerce system.
 * This data class holds all the essential information about a product.
 *
 * @property id The unique identifier for the product.
 * @property title The name or title of the product.
 * @property description A detailed description of the product.
 * @property price The price of the product.
 * @property category The category to which the product belongs.
 * @property imageUrl The URL of an image representing the product.
 */
data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val category: String,
    val imageUrl: String,
)
