package com.example.smup.ui.makeid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.smup.R

class MakeidFinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makeid_finish)

        val btn : Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            finish()
        }

    }
}