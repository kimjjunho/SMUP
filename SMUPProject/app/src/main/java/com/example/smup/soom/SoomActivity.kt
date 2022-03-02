package com.example.smup.soom

import android.content.Intent
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

        mBinding.two.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.soom_frame, SOOMFragment())
                .commit()
        }
    }
    fun changeFragment(index:Int){
        when(index){
            1 -> supportFragmentManager.beginTransaction()
                .replace(R.id.soom_frame, SOOMFragment())
                .commit()
            2 -> supportFragmentManager.beginTransaction()
                .replace(R.id.soom_frame, FindFragment())
                .commit()
            3 -> supportFragmentManager.beginTransaction()
                .replace(R.id.soom_frame, ChatFragment())
                .commit()
            4 -> supportFragmentManager.beginTransaction()
                .replace(R.id.soom_frame, AccountFragment())
                .commit()
            5 -> startActivity(Intent(applicationContext, MakeSoomActivity::class.java))
        }
    }
}