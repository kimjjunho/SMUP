package com.example.smup.di.module

import com.example.smup.data.login.LoginRepository
import com.example.smup.feature.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    single { LoginRepository() }
    viewModel { LoginViewModel(get()) }
}