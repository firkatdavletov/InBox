package org.example.project.domain.interactors

import kotlinx.coroutines.flow.Flow
import org.example.project.domain.models.LoginResult
import org.example.project.domain.repositories.UserRepository
import org.example.project.features.login_component.LoginInteractor

class DefaultLoginInteractor(
    private val userRepository: UserRepository
) : LoginInteractor {
    override fun login(phone: String): Flow<LoginResult> {
        return userRepository.login(phone)
    }
}