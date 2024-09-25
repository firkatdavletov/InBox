package org.example.project.di

import org.example.project.data.api.user_api.UserApi
import org.example.project.data.repositories.DefaultUserRepository
import org.example.project.domain.repositories.UserRepository
import org.koin.dsl.module

fun appModule() = module {
    single<UserRepository> { DefaultUserRepository(get()) }
    single { UserApi() }
}