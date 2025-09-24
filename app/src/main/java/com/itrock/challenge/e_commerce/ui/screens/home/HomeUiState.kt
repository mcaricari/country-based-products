package com.itrock.challenge.e_commerce.ui.screens.home

import com.itrock.challenge.e_commerce.domain.model.Product

sealed interface HomeUiState {
    data class Success(val products: List<Product>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

