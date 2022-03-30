package com.example.smup.di.module

import com.example.smup.data.home.schedule.ScheduleRepository
import com.example.smup.feature.home.schedule.viewmodel.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val scheduleModule = module {
    single { ScheduleRepository() }
    viewModel { ScheduleViewModel(get()) }
}