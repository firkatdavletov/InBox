package org.example.project.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import org.example.project.features.home_component.DefaultHomeComponent
import org.example.project.features.home_component.HomeComponent
import org.example.project.features.login_component.DefaultLoginComponent
import org.example.project.features.login_component.LoginComponent
import org.koin.core.component.KoinComponent


class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext, KoinComponent {
    private val navigation  = StackNavigation<Config>()
    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Login,
            handleBackButton = true,
            childFactory = ::createChild
        )

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(toIndex)
    }

    private fun createChild(config: Config, componentContext: ComponentContext): RootComponent.Child {
        return when (config) {
            is Config.Login -> RootComponent.Child.LoginChild(loginChild(componentContext))
            is Config.Home -> RootComponent.Child.HomeChild(homeChild(componentContext))
        }
    }

    private fun loginChild(componentContext: ComponentContext): LoginComponent {
        return DefaultLoginComponent(
            componentContext = componentContext
        )
    }

    private fun homeChild(componentContext: ComponentContext): HomeComponent {
        return DefaultHomeComponent(
            componentContext = componentContext,
            finish = {
                navigation.pop()
            }
        )
    }

    @Serializable
    private sealed class Config {
        @Serializable
        data object Login : Config()

        @Serializable
        data object Home : Config()

    }
}