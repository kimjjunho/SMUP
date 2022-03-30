package com.example.smup.feature.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smup.feature.MainActivity
import com.example.smup.R
import com.example.smup.databinding.FragmentHomeBinding
import com.example.smup.feature.home.alarm.AlarmActivity
import com.example.smup.feature.home.meal.ui.MealFragment
import com.example.smup.feature.home.schedule.ui.ScheduleFragment

class HomeFragment : Fragment() {

    private var mBinding : FragmentHomeBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        val binding = FragmentHomeBinding.bind(view)
        val mainActivity = activity as MainActivity

        val scheduleFragment0 = ScheduleFragment()
        childFragmentManager.beginTransaction().replace(R.id.home_frame, scheduleFragment0).commit()

        binding.alarmImage.setOnClickListener {
            startActivity(Intent(mainActivity, AlarmActivity::class.java))
        }

        binding.radioGroup.setOnCheckedChangeListener{ radioGroup, i ->
            when(i){
                R.id.schedule_btn->{
                    val scheduleFragment = ScheduleFragment()
                    childFragmentManager.beginTransaction()
                        .replace(R.id.home_frame,scheduleFragment)
                        .commit()
                }
                R.id.meal_btn->{
                    val mealFragment = MealFragment()
                    childFragmentManager.beginTransaction()
                        .replace(R.id.home_frame,mealFragment)
                        .commit()
                }
            }
        }

        return view
    }

    companion object {

    }
}