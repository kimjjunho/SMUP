package com.example.smup.data.home

import com.example.smup.feature.login.model.LoginRequest
import com.example.smup.feature.login.model.LoginResponse
import com.example.smup.feature.loginApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MealRepository {
    fun login(loginRequest: LoginRequest) : @NonNull Single<Response<LoginResponse>> =
        loginApi.login(loginRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}