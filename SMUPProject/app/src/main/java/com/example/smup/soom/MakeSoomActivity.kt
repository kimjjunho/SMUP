package com.example.smup.soom

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.smup.R
import com.example.smup.databinding.ActivityMakeSoomBinding

class MakeSoomActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMakeSoomBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_soom)

        mBinding = ActivityMakeSoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.back.setOnClickListener {
            finish()
        }

        mBinding.nameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.nameText.text.isEmpty()){
                    mBinding.nameLine.setBackgroundColor(applicationContext.getColor(R.color.gray))
                }else{
                    mBinding.nameLine.setBackgroundColor(applicationContext.getColor(R.color.black))
                }
                if(mBinding.nameText.text.isNotEmpty() &&mBinding.mainText.text.isNotEmpty()){
                    mBinding.backImage.setBackgroundResource(R.drawable.soom_button_makesoom_purple)
                    mBinding.makeBtn.visibility = View.VISIBLE
                }else{
                    mBinding.backImage.setBackgroundResource(R.drawable.soom_button_makesoom_gray)
                    mBinding.makeBtn.visibility = View.INVISIBLE
                }
            }
            override fun afterTextChanged(p0: Editable?) {}

        })
        mBinding.mainText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.mainText.text.isEmpty()){
                    mBinding.mainLine.setBackgroundColor(applicationContext.getColor(R.color.gray))
                }else{
                    mBinding.mainLine.setBackgroundColor(applicationContext.getColor(R.color.black))
                }
                if(mBinding.nameText.text.isNotEmpty() &&mBinding.mainText.text.isNotEmpty()){
                    mBinding.backImage.setBackgroundResource(R.drawable.soom_button_makesoom_purple)
                    mBinding.makeBtn.visibility = View.VISIBLE

                }else{
                    mBinding.backImage.setBackgroundResource(R.drawable.soom_button_makesoom_gray)
                    mBinding.makeBtn.visibility = View.INVISIBLE
                }
            }
            override fun afterTextChanged(p0: Editable?) {}

        })
    }
}