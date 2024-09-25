package org.example.project.features.login_component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultLoginComponent(
    componentContext: ComponentContext
) : LoginComponent, ComponentContext by componentContext {

    private val _phoneState = MutableValue("")

    override val phoneState: Value<String> = _phoneState

    private val _screenState = MutableValue<LoginComponent.ScreenState>(
        LoginComponent.ScreenState.Success
    )

    override val screenState: Value<LoginComponent.ScreenState> = _screenState

    override fun onPhoneChanged(phone: String) {
        _phoneState.update { phone }
    }

    override fun onLoginClicked() {
        _screenState.update { LoginComponent.ScreenState.Loading }
    }
}