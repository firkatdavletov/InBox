package org.example.project.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.example.project.data.api.user_api.UserApi
import org.example.project.data.api.user_api.entities.LoginResultEntity
import org.example.project.domain.models.LoginResult
import org.example.project.domain.repositories.UserRepository

class DefaultUserRepository(
    private val userApi: UserApi
): UserRepository {

    override fun login(phone: String): Flow<LoginResult> {
        return userApi.login(phone)
            .map { it.toModel() }
    }

    private fun LoginResultEntity.toModel(): LoginResult {
        return when (this) {
            LoginResultEntity.Success -> LoginResult.Success
            LoginResultEntity.Error -> LoginResult.Error
        }
    }
}