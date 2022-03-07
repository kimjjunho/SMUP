package com.example.smup.home.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
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

        val alarmList : ArrayList<AlarmData> = ArrayList()
        alarmList.add(AlarmData("테스트"))
        alarmList.add(AlarmData("테스트2"))
        val recyclerViewAdapter = AlarmAdapter(alarmList)

        mBinding.rV.adapter = recyclerViewAdapter
        val alarmSwipeHelper = AlarmSwipeHelper(recyclerViewAdapter).apply {
            setClamp(resources.displayMetrics.widthPixels.toFloat() / 4)    // 1080 / 4 = 270, 1080 / 3 = 360,
        }
        ItemTouchHelper(alarmSwipeHelper).attachToRecyclerView(mBinding.rV)

        mBinding.rV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        mBinding.rV.setHasFixedSize(true)

        mBinding.backImage.setOnClickListener {
            finish()
        }

        binding.rV.setOnTouchListener { _, _ ->
            alarmSwipeHelper.removePreviousClamp(mBinding.rV)
            false
        }
    }
}