package com.itrock.challenge.e_commerce.data.model

import com.itrock.challenge.e_commerce.domain.model.Product

/**
 * Data Transfer Object (DTO) representing a product as received from the Platzi API.
 * This class maps directly to the structure of the product data in the API response.
 *
 * @property id The unique identifier of the product.
 * @property title The title or name of the product.
 * @property description A detailed description of the product.
 * @property price The price of the product.
 * @property images A list of URLs for product images.
 * @property category The [CategoryDto] object associated with this product.
 */
data class PlatziProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val images: List<String>,
    val category: CategoryDto,
)

/**
 * Data Transfer Object (DTO) representing a product category as received from the Platzi API.
 *
 * @property name The name of the category.
 */
data class CategoryDto(
    val name: String,
)

/**
 * Converts a [PlatziProductDto] to a domain [Product] model.
 * This function maps the API-specific DTO to the application's internal data model,
 * ensuring a separation between data layer and domain layer representations.
 *
 * @return The corresponding [Product] object.
 */
fun PlatziProductDto.toDomain() = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    category = category.name,
    imageUrl = images.firstOrNull() ?: ""
)

