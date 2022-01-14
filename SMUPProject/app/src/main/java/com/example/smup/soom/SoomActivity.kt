package com.example.smup.soom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smup.R
import com.example.smup.databinding.ActivitySoomBinding

class SoomActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivitySoomBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soom)

        mBinding = ActivitySoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.soom_frame, MainFragment())
            .commit()

        mBinding.back.setOnClickListener {
            finish()
        }

    }
}