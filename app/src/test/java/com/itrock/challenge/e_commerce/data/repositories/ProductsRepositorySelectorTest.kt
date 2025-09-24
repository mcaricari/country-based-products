package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.domain.interfaces.ProductsRepository
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProductsRepositorySelectorTest {

    private lateinit var platziProductsRepository: PlatziProductsRepository
    private lateinit var fakeProductsRepository: FakeProductsRepository
    private lateinit var productsRepositorySelector: ProductsRepositorySelector

    @Before
    fun setUp() {
        platziProductsRepository = mockk<PlatziProductsRepository>()
        fakeProductsRepository = mockk<FakeProductsRepository>()
        productsRepositorySelector = ProductsRepositorySelector(
            platziRepo = platziProductsRepository,
            fakeRepo = fakeProductsRepository
        )
    }

    @Test
    fun `getSource should return FakeProductsRepository when no source is selected initially`() {
        val selectedRepository = productsRepositorySelector.getSource()
        assertEquals(fakeProductsRepository, selectedRepository)
    }

    @Test
    fun `getSource should return FakeProductsRepository when sourceId is 0`() {
        val sourceId = 0
        productsRepositorySelector.selectSource(sourceId)
        val selectedRepository = productsRepositorySelector.getSource()
        assertEquals(fakeProductsRepository, selectedRepository)
    }

    @Test
    fun `getSource should return PlatziProductsRepository when sourceId is 1`() {
        val sourceId = 1
        productsRepositorySelector.selectSource(sourceId)
        val selectedRepository = productsRepositorySelector.getSource()
        assertEquals(platziProductsRepository, selectedRepository)
    }

    @Test
    fun `getSource should return PlatziProductsRepository when sourceId is any non-zero value`() {
        val sourceId = 123
        productsRepositorySelector.selectSource(sourceId)
        val selectedRepository = productsRepositorySelector.getSource()
        assertEquals(platziProductsRepository, selectedRepository)
    }
}
