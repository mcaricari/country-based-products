package com.itrock.challenge.e_commerce.data.model

import com.itrock.challenge.e_commerce.domain.model.Product

data class FakeProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val category: String,
    val image: String,
)

fun FakeProductDto.toDomain() = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    category = category,
    imageUrl = image
)
