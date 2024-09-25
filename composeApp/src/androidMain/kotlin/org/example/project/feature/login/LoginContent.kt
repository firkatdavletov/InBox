package org.example.project.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.example.project.features.login_component.LoginComponent

@Composable
fun LoginContent(component: LoginComponent) {
    val phoneNumber = component.phoneState.subscribeAsState()
    Scaffold { scaffoldPadding ->
        Box(
            modifier = Modifier
                .padding(scaffoldPadding)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Введите номер телефона:",
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = phoneNumber.value,
                    onValueChange = {
                        component.onPhoneChanged(it)
                    }
                )
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        component.onLoginClicked()
                    }
                ) {
                    Text("СМС")
                }
            }
        }
    }
}