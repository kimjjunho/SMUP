package com.example.smup.home.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smup.R
import com.example.smup.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityAlarmBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        mBinding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.backImage.setOnClickListener {
            finish()
        }
    }
}