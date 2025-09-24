package com.itrock.challenge.e_commerce.ui.screens.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itrock.challenge.e_commerce.domain.usecases.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel
@Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state: MutableStateFlow<DetailUiState> =
        MutableStateFlow(DetailUiState.Loading)
    val state: StateFlow<DetailUiState> = _state.asStateFlow()

    init {
        val id = savedStateHandle.get<Int>("productId") ?: 0
        getProduct(id)
    }

    private fun getProduct(id: Int) {
        viewModelScope.launch {
            _state.value = DetailUiState.Loading
            _state.value = try {
                val products = getProductByIdUseCase(id)
                DetailUiState.Success(products)
            } catch (e: IOException) {
                Log.e(TAG, "Error fetching products", e)
                DetailUiState.Error
            } catch (e: HttpException) {
                Log.e(TAG, "Error fetching products", e)
                DetailUiState.Error
            }
        }
    }

    private companion object {
        const val TAG = "DetailScreenViewModel"
    }
}