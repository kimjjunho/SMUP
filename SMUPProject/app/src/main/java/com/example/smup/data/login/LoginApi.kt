package com.example.smup.data.login

import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("auth/login")
    fun login(
        @Body
    )
}