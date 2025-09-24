package com.itrock.challenge.e_commerce.ui.screens.login

import androidx.lifecycle.ViewModel
import com.itrock.challenge.e_commerce.domain.usecases.SelectSourceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel
@Inject constructor(private val selectSourceUseCase: SelectSourceUseCase) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val validUsername = "user123"
    private val validPassword = "pass123"

    fun onUsernameChange(username: String) {
        _state.value = _state.value.copy(username = username)
    }

    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun onSourceChange(id: Int) {
        selectSourceUseCase(id)
    }

    fun login(): Boolean =
        _state.value.username == validUsername && _state.value.password == validPassword

}