package com.itrock.challenge.e_commerce.data.repositories

import com.itrock.challenge.e_commerce.data.api.FakeApi
import com.itrock.challenge.e_commerce.data.model.FakeProductDto
import com.itrock.challenge.e_commerce.data.model.toDomain
import com.itrock.challenge.e_commerce.domain.model.Product
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FakeProductsRepositoryTest {

    private lateinit var fakeApi: FakeApi
    private lateinit var fakeProductsRepository: FakeProductsRepository

    @Before
    fun setUp() {
        fakeApi = mockk(relaxed = true)
        fakeProductsRepository = FakeProductsRepository(fakeApi)
    }

    @Test
    fun `getProducts should call api and return mapped products`() = runBlocking {
        val fakeProductDtoList = listOf(
            FakeProductDto(1, "Fake Product 1", "Description 1", 10.0f, "Category 1", "image1.jpg"),
            FakeProductDto(2, "Fake Product 2", "Description 2", 20.0f, "Category 2", "image2.jpg")
        )
        val expectedProducts = fakeProductDtoList.map { it.toDomain() }
        coEvery { fakeApi.getProducts() } returns fakeProductDtoList

        val result = fakeProductsRepository.getProducts()

        coVerify { fakeApi.getProducts() }
        assertEquals(expectedProducts, result)
    }

    @Test
    fun `getProducts should return empty list when api returns empty list`() = runBlocking {
        coEvery { fakeApi.getProducts() } returns emptyList()

        val result = fakeProductsRepository.getProducts()

        coVerify { fakeApi.getProducts() }
        assertEquals(emptyList<Product>(), result)
    }

    @Test
    fun `getProduct should call api with id and return mapped product`() = runBlocking {
        val productId = 1
        val fakeProductDto = FakeProductDto(
            productId,
            "Fake Product 1",
            "Description 1",
            10.0f,
            "Category 1",
            "image1.jpg"
        )
        val expectedProduct = fakeProductDto.toDomain()
        coEvery { fakeApi.getProduct(productId) } returns fakeProductDto

        val result = fakeProductsRepository.getProduct(productId)

        coVerify { fakeApi.getProduct(productId) }
        assertEquals(expectedProduct, result)
    }
}
