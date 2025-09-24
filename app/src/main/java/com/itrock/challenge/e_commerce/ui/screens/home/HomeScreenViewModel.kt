package com.itrock.challenge.e_commerce.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itrock.challenge.e_commerce.domain.usecases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel
@Inject constructor(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {
    private val _state: MutableStateFlow<HomeUiState> =
        MutableStateFlow(HomeUiState.Loading)
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _state.value = HomeUiState.Loading
            _state.value = try {
                val products = getProductsUseCase()
                HomeUiState.Success(products)
            } catch (e: IOException) {
                Log.e(TAG, "Error fetching products", e)
                HomeUiState.Error
            } catch (e: HttpException) {
                Log.e(TAG, "Error fetching products", e)
                HomeUiState.Error
            }
        }
    }

    private companion object {
        const val TAG = "ProductsScreenViewModel"
    }
}