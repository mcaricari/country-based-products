package com.itrock.challenge.e_commerce.ui.screens.detail

import com.itrock.challenge.e_commerce.domain.model.Product

sealed interface DetailUiState {
    data class Success(val product: Product) : DetailUiState
    object Error : DetailUiState
    object Loading : DetailUiState
}
