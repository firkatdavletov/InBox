package org.example.project.domain.models

sealed class LoginResult {
    data object Success: LoginResult()
    data object Error: LoginResult()
}