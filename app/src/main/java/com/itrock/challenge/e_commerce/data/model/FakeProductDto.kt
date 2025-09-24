package com.itrock.challenge.e_commerce.data.model

import com.itrock.challenge.e_commerce.domain.model.Product

/**
 * Data Transfer Object (DTO) representing a product for the fake data source.
 * This class is used for providing sample or placeholder product data, often for
 * testing or development purposes.
 *
 * @property id The unique identifier of the fake product.
 * @property title The title or name of the fake product.
 * @property description A detailed description of the fake product.
 * @property price The price of the fake product.
 * @property category The category to which the fake product belongs.
 * @property image The URL of an image for the fake product.
 */
data class FakeProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val category: String,
    val image: String,
)

/**
 * Converts a [FakeProductDto] to a domain [Product] model.
 * This function maps the DTO used for fake data to the application's
 * internal [Product] model.
 *
 * @return The corresponding [Product] object.
 */
fun FakeProductDto.toDomain() = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    category = category,
    imageUrl = image
)
