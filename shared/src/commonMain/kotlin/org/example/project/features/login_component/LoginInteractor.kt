package org.example.project.features.login_component

import kotlinx.coroutines.flow.Flow
import org.example.project.domain.models.LoginResult

interface LoginInteractor {
    fun login(phone: String): Flow<LoginResult>
}