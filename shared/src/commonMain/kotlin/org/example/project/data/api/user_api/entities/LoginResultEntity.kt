package org.example.project.data.api.user_api.entities

sealed class LoginResultEntity {
    data object Success: LoginResultEntity()
    data object Error: LoginResultEntity()

}
