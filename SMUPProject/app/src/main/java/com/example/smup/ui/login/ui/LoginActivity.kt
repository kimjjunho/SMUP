package com.example.smup.ui.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smup.R
import com.example.smup.databinding.ActivityLoginBinding
import com.example.smup.ui.MainActivity
import com.example.smup.ui.makeid.MakeIdActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityLoginBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.signBtn.setOnClickListener {
            startActivity(Intent(this, MakeIdActivity::class.java))
        }
        mBinding.loginBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}