package com.example.smup.feature.login.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("deviceToken") val deviceToken : String,
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String
)
