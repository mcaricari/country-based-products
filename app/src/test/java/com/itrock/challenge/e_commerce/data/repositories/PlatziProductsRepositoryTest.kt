package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.data.api.PlatziApi
import com.itrock.challenge.e_commerce.data.model.CategoryDto
import com.itrock.challenge.e_commerce.data.model.PlatziProductDto
import com.itrock.challenge.e_commerce.data.model.toDomain
import com.itrock.challenge.e_commerce.domain.model.Product
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PlatziProductsRepositoryTest {

    private lateinit var platziApi: PlatziApi
    private lateinit var repository: PlatziProductsRepository

    @Before
    fun setUp() {
        platziApi = mockk()
        repository = PlatziProductsRepository(platziApi)
    }

    @Test
    fun `getProducts should return mapped products when api call is successful`() = runTest {
        val platziProductDtoList = listOf(
            PlatziProductDto(
                1,
                "Product 1",
                "Desc 1",
                10.0f,
                listOf("image1.jpg"),
                CategoryDto("Category 1")
            ),
            PlatziProductDto(
                2,
                "Product 2",
                "Desc 2",
                20.0f,
                listOf("image2.jpg"),
                CategoryDto("Category 2")
            )
        )
        val expectedProducts = platziProductDtoList.map { it.toDomain() }
        coEvery { platziApi.getProducts() } returns platziProductDtoList

        val result = repository.getProducts()

        coVerify { platziApi.getProducts() }
        assertEquals(expectedProducts, result)
    }

    @Test
    fun `getProducts should return empty list when api returns empty list`() = runTest {
        coEvery { platziApi.getProducts() } returns emptyList()

        val result = repository.getProducts()

        coVerify { platziApi.getProducts() }
        assertEquals(emptyList<Product>(), result)
    }

    @Test
    fun `getProduct should return mapped product when api call is successful`() = runTest {
        val productId = 1
        val platziProductDto = PlatziProductDto(
            productId,
            "Product 1",
            "Desc 1",
            10.0f,
            listOf("image1.jpg"),
            CategoryDto("Category 1")
        )
        val expectedProduct = platziProductDto.toDomain()
        coEvery { platziApi.getProduct(productId) } returns platziProductDto

        val result = repository.getProduct(productId)

        coVerify { platziApi.getProduct(productId) }
        assertEquals(expectedProduct, result)
    }
}
