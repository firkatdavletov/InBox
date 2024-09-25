package org.example.project.features.login_component

import com.arkivanov.decompose.value.Value

interface LoginComponent {
    val phoneState: Value<String>
    val screenState: Value<ScreenState>
    fun onPhoneChanged(phone: String)
    fun onLoginClicked()

    sealed interface ScreenState {
        data object Success : ScreenState
        data object Loading : ScreenState
    }
}