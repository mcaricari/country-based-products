package com.itrock.challenge.e_commerce.ui.home

import android.util.Log
import com.itrock.challenge.e_commerce.domain.model.Product
import com.itrock.challenge.e_commerce.domain.usecases.GetProductsUseCase
import com.itrock.challenge.e_commerce.ui.screens.home.HomeScreenViewModel
import com.itrock.challenge.e_commerce.ui.screens.home.HomeUiState
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class HomeScreenViewModelTest {
    private lateinit var getProductsUseCase: GetProductsUseCase
    private lateinit var viewModel: HomeScreenViewModel

    private val testDispatcher =
        StandardTestDispatcher()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        mockkStatic(Log::class)
        every { Log.v(any(), any(), any()) } returns 0
        every { Log.d(any(), any(), any()) } returns 0
        every { Log.i(any(), any(), any()) } returns 0
        every { Log.e(any(), any(), any()) } returns 0
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Product list should be updated when getProductsUseCase returns a list`() =
        runTest(testDispatcher) {
            val products = listOf(
                Product(1, "Product 1", "Description 1", 10.0f, "Category 1", "image1.jpg"),
                Product(2, "Product 2", "Description 2", 20.0f, "Category 2", "image2.jpg")
            )
            getProductsUseCase = mockk()
            coEvery { getProductsUseCase() } returns products

            viewModel = HomeScreenViewModel(getProductsUseCase)
            advanceUntilIdle()
            val result = viewModel.state.value

            assert(result is HomeUiState.Success)
            assertEquals(products, (result as HomeUiState.Success).products)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Show error message when getProductsUseCase throws an exception`() =
        runTest(testDispatcher) {
            getProductsUseCase = mockk()
            coEvery { getProductsUseCase() } throws IOException()

            viewModel = HomeScreenViewModel(getProductsUseCase)
            advanceUntilIdle()
            val result = viewModel.state.value

            assert(result is HomeUiState.Error)
        }
}