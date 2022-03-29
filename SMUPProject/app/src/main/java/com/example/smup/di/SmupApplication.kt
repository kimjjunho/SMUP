package com.example.smup.di

import android.app.Application
import com.example.smup.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SmupApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SmupApplication)

            modules(
                listOf(
                    loginModule,
                    mealModule
                )
            )
        }
    }
}