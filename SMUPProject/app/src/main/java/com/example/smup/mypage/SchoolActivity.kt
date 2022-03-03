package com.example.smup.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smup.R
import com.example.smup.databinding.ActivitySchoolBinding
import com.example.smup.databinding.ActivityUserBinding

class SchoolActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySchoolBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school)

        mBinding = ActivitySchoolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.backImage.setOnClickListener {
            finish()
        }
    }
}