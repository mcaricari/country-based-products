package com.itrock.challenge.e_commerce.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.itrock.challenge.e_commerce.domain.model.Product
import com.itrock.challenge.e_commerce.ui.screens.components.ProductPrev
import com.itrock.challenge.e_commerce.ui.screens.error.ErrorScreen
import com.itrock.challenge.e_commerce.ui.screens.loading.LoadingScreen

@Composable
fun HomeScreen(
    onProductClick: (Int) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    when (state) {
        HomeUiState.Error -> ErrorScreen("Ocurrió un error al cargar los productos")
        HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Success -> ProductList(
            (state as HomeUiState.Success).products,
            onProductClick
        )
    }
}

@Composable
fun ProductList(products: List<Product>, onProductClick: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        products.forEach { product ->
            item {
                ProductPrev(product, onProductClick)
            }
        }
    }
}




