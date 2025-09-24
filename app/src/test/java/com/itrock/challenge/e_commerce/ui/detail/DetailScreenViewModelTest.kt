package com.itrock.challenge.e_commerce.ui.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.itrock.challenge.e_commerce.domain.model.Product
import com.itrock.challenge.e_commerce.domain.usecases.GetProductByIdUseCase
import com.itrock.challenge.e_commerce.ui.screens.detail.DetailScreenViewModel
import com.itrock.challenge.e_commerce.ui.screens.detail.DetailUiState
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

class DetailScreenViewModelTest {
    private lateinit var getProductUseCase: GetProductByIdUseCase
    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var viewModel: DetailScreenViewModel

    private val testDispatcher =
        StandardTestDispatcher()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        savedStateHandle = mockk()
        every { savedStateHandle.get<Int>("productId") } returns 1

        mockkStatic(Log::class)
        every { Log.v(any(), any(), any()) } returns 0
        every { Log.d(any(), any(), any()) } returns 0
        every { Log.i(any(), any(), any()) } returns 0
        every { Log.e(any(), any(), any()) } returns 0
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Product should be shown when getProductUseCase returns a product`() =
        runTest(testDispatcher) {
            val product =
                Product(1, "Product 1", "Description 1", 10.0f, "Category 1", "image1.jpg")

            getProductUseCase = mockk()
            coEvery { getProductUseCase(any()) } returns product

            viewModel = DetailScreenViewModel(getProductUseCase, savedStateHandle)
            advanceUntilIdle()
            val result = viewModel.state.value

            assert(result is DetailUiState.Success)
            assertEquals(product, (result as DetailUiState.Success).product)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Error state should be shown when getProductUseCase throws an exception`() =
        runTest(testDispatcher) {
            getProductUseCase = mockk()
            coEvery { getProductUseCase(any()) } throws IOException()

            viewModel = DetailScreenViewModel(getProductUseCase, savedStateHandle)

            advanceUntilIdle()
            val result = viewModel.state.value

            assert(result is DetailUiState.Error)
        }
}