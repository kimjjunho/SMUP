package com.example.smup.feature.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smup.R
import com.example.smup.databinding.ActivityRingBinding

class RingActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRingBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ring)

        mBinding = ActivityRingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.backImage.setOnClickListener {
            finish()
        }
    }
}