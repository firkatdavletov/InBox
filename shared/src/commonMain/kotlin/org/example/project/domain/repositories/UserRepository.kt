package org.example.project.domain.repositories

import kotlinx.coroutines.flow.Flow
import org.example.project.domain.models.LoginResult

interface UserRepository {
    fun login(phone: String): Flow<LoginResult>
}