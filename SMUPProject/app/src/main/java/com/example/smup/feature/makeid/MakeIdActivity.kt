package com.example.smup.feature.makeid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.smup.R

class MakeIdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_id)

        val back : ImageButton = findViewById(R.id.back)
        val informationFragment = InforamationFragment()

        back.setOnClickListener {
            onBackPressed()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, informationFragment)
            .commit()

    }

    fun move(){
        startActivity(Intent(this,MakeidFinishActivity::class.java))
        finish()
    }
}