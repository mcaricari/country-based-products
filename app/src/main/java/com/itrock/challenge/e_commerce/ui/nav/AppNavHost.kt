package com.itrock.challenge.e_commerce.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.itrock.challenge.e_commerce.ui.screens.detail.ProductDetailScreen
import com.itrock.challenge.e_commerce.ui.screens.home.HomeScreen
import com.itrock.challenge.e_commerce.ui.screens.login.LoginScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LOGIN.name,
        modifier = modifier,
    ) {
        composable(Screen.LOGIN.name) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.HOME.name) {
                        popUpTo(Screen.LOGIN.name) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.HOME.name) {
            HomeScreen(
                onProductClick = { productId ->
                    navController.navigate("${Screen.DETAIL.name}/$productId")
                }
            )
        }
        composable(
            route = "${Screen.DETAIL.name}/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) {
            ProductDetailScreen(
                onBuyClick = { navController.navigateUp() },
                onBackClick = { navController.navigateUp() }
            )
        }

    }
}
