package org.example.project.data.api.user_api

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.data.api.user_api.entities.LoginResultEntity

class UserApi {
    fun login(phone: String): Flow<LoginResultEntity> {
        return flow {
            val smsCode = "200"
            delay(1_000)
            emit(LoginResultEntity.Success)
        }
    }
}