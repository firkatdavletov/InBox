package org.example.project

import android.app.Application
import com.arkivanov.decompose.ComponentContext
import org.example.project.di.appModule
import org.example.project.navigation.DefaultRootComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.dsl.module

class InboxApplication: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appModule())
        }
    }
}