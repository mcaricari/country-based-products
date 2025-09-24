package com.itrock.challenge.e_commerce.data.model

import com.itrock.challenge.e_commerce.domain.model.Product

data class PlatziProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val images: List<String>,
    val category: CategoryDto,
)

data class CategoryDto(
    val name: String,
)

fun PlatziProductDto.toDomain() = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    category = category.name,
    imageUrl = images.firstOrNull() ?: ""
)

