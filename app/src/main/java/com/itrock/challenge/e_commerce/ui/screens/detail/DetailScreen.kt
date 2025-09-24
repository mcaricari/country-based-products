package com.itrock.challenge.e_commerce.ui.screens.detail

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.itrock.challenge.e_commerce.R
import com.itrock.challenge.e_commerce.domain.model.Product
import com.itrock.challenge.e_commerce.ui.screens.error.ErrorScreen
import com.itrock.challenge.e_commerce.ui.screens.loading.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    onBuyClick: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: DetailScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar (
                title = { Text(stringResource(R.string.product_detail_app_bar_title)) },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.icon_back_content_Desc)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        when (state) {
            DetailUiState.Error -> ErrorScreen(
                R.string.detail_screen_error_msg,
                Modifier.padding(innerPadding)
            )

            DetailUiState.Loading -> LoadingScreen(Modifier.padding(innerPadding))
            is DetailUiState.Success -> {
                val product = (state as DetailUiState.Success).product
                ProductDetail(product, onBuyClick)
            }
        }
    }
}

@Composable
fun ProductDetail(
    product: Product,
    onBuyClick: () -> Unit,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = product.title,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "$ ${product.price}",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = product.category,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )

        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            onBuyClick()
            Toast.makeText(context,
                context.getString(R.string.bought_toast_text), Toast.LENGTH_SHORT).show()
        }) {
            Text(stringResource(R.string.buy_button_text))
        }
    }
}