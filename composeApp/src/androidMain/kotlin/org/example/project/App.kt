package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.navigation.RootComponent
import org.example.project.navigation.RootContent

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        RootContent(rootComponent)
    }
}