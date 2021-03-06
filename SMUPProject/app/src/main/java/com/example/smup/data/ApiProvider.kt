package com.example.smup.feature

import com.example.smup.data.home.meal.MealApi
import com.example.smup.data.login.LoginApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl(BASE_URL)
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    addConverterFactory(GsonConverterFactory.create())
}.build()

val mealApi : MealApi by lazy {
    retrofit.create(MealApi::class.java)
}

val loginApi : LoginApi by lazy {
    retrofit.create(LoginApi::class.java)
}
