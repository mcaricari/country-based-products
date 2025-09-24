package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import com.itrock.challenge.e_commerce.domain.interfaces.SourceSelector
import javax.inject.Inject

/**
 * Implements [SourceSelector] to allow switching between different product data sources.
 * This class holds references to different [ProductsRepository] implementations and provides
 * a mechanism to select the active one.
 *
 * @param platziRepo The repository for accessing products from the Platzi API.
 * @param fakeRepo The repository for accessing the Fake API.
 */
class ProductsRepositorySelector
@Inject constructor(
    private val platziRepo: PlatziProductsRepository,
    private val fakeRepo: FakeProductsRepository
) : SourceSelector {
    private var source = 0

    /**
     * Selects the active data source based on the provided [id].
     *
     * @param id An integer used to select the source.
     */
    override fun selectSource(id: Int) {
        source = id
    }

    /**
     * Retrieves the currently selected [ProductsRepository].
     *
     * @return The [FakeProductsRepository] if the internal source identifier is 0,
     *         otherwise returns the [PlatziProductsRepository].
     */
    override fun getSource(): ProductsRepository = if (source == 0) fakeRepo else platziRepo
}
