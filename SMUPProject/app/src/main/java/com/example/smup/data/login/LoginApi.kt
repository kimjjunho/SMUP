package com.example.smup.data.login

import com.example.smup.feature.MealResponse
import com.example.smup.feature.login.model.LoginRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Single<Response<MealResponse>>

}