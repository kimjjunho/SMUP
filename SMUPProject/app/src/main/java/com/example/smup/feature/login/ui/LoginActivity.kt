package com.example.smup.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.smup.R
import com.example.smup.databinding.ActivityLoginBinding
import com.example.smup.feature.MainActivity
import com.example.smup.feature.login.model.LoginRequest
import com.example.smup.feature.login.viewmodel.LoginViewModel
import com.example.smup.feature.makeid.MakeIdActivity
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.sign

class LoginActivity : AppCompatActivity() {

    private lateinit var dBinding : ActivityLoginBinding
    private val binding get() = dBinding
    val vm : LoginViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        setContentView(binding.root)

        dBinding.signBtn.setOnClickListener {
            startActivity(Intent(this, MakeIdActivity::class.java))
        }
        dBinding.loginBtn.setOnClickListener {
            val textId = dBinding.textId.text.toString()
            val textPass = dBinding.textPass.text.toString()
            vm.login(LoginRequest("deviceToken",textId,textPass))

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        observeEvent()
    }

    fun observeEvent(){
        vm.success.observe(this@LoginActivity,{
                it.run {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
        })
    }
}