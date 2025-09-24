package com.itrock.challenge.e_commerce.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.itrock.challenge.e_commerce.R
import com.itrock.challenge.e_commerce.domain.model.Product
import com.itrock.challenge.e_commerce.ui.screens.components.ProductPrev
import com.itrock.challenge.e_commerce.ui.screens.error.ErrorScreen
import com.itrock.challenge.e_commerce.ui.screens.loading.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onProductClick: (Int) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.home_top_app_bar_title)) },
            )
        }
    ) { innerPadding ->
        when (state) {
            HomeUiState.Error -> ErrorScreen(
                R.string.home_screen_error_msg,
                Modifier.padding(innerPadding)
            )

            HomeUiState.Loading -> LoadingScreen(Modifier.padding(innerPadding))
            is HomeUiState.Success -> ProductList(
                (state as HomeUiState.Success).products,
                onProductClick,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun ProductList(
    products: List<Product>,
    onProductClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
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




