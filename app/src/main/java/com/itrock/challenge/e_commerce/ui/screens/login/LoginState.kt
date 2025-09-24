package com.itrock.challenge.e_commerce.ui.screens.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val showError: Boolean = false,
    val loginSuccess: Boolean = false
)
