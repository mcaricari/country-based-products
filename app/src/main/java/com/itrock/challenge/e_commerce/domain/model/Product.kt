package com.itrock.challenge.e_commerce.domain.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val category: String,
    val imageUrl: String,
)