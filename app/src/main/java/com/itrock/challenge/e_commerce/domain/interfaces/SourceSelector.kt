package com.itrock.challenge.e_commerce.domain.interfaces

interface SourceSelector {
    fun selectSource(id: Int)
    fun getSource(): ProductsRepository
}