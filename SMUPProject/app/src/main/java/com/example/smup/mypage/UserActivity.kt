package com.example.smup.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smup.R
import com.example.smup.databinding.ActivitySoomBinding
import com.example.smup.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityUserBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        mBinding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.cancelBtn.setOnClickListener {
            finish()
        }
    }
}