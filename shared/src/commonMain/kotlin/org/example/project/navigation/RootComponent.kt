package org.example.project.navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.example.project.features.home_component.HomeComponent
import org.example.project.features.login_component.LoginComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class LoginChild(val component: LoginComponent) : Child()
        class HomeChild(val component: HomeComponent) : Child()
    }
}