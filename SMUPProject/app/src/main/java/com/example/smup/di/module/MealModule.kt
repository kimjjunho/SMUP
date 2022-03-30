package com.example.smup.di.module

import com.example.smup.data.home.meal.MealRepository
import com.example.smup.feature.home.meal.viewmodel.MealViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mealModule = module {
    single { MealRepository() }
    viewModel { MealViewModel(get()) }
}