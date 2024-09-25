package org.example.project.features.home_component

import com.arkivanov.decompose.ComponentContext

class DefaultHomeComponent(
    componentContext: ComponentContext,
    private val finish: () -> Unit
): HomeComponent, ComponentContext by componentContext {
    override fun onFinish() {
        finish()
    }
}