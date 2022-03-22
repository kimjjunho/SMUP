package com.example.smup.feature.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smup.data.login.LoginRepository
import com.example.smup.feature.ACCESS_TOKEN
import com.example.smup.feature.REFRESH_TOKEN
import com.example.smup.feature.login.model.LoginRequest

class LoginViewModel(
    private val rp:LoginRepository
):ViewModel(){
    val success : MutableLiveData<Boolean> = MutableLiveData()
    val faild : MutableLiveData<Boolean> = MutableLiveData()

    fun login(loginRequest: LoginRequest){
        rp.login(loginRequest).subscribe { response ->
            if(response.isSuccessful){
                ACCESS_TOKEN = "Bearer " + response.body()?.accessToken.toString()
                REFRESH_TOKEN = response.body()?.refreshToken.toString()
                success.value = true
            }else{
                faild.value = true
            }

        }
    }
}