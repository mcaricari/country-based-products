package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import javax.inject.Inject

class ProductsRepositorySelector
@Inject constructor(
    private val platziRepo: PlatziProductsRepository,
    private val fakeRepo: FakeProductsRepository
) : SourceSelector {
    private var source = 0

    override fun selectSource(id: Int) {
        source = id
    }

    override fun getSource(): ProductsRepository = if (source == 0) fakeRepo else platziRepo
}