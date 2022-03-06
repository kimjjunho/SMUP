package com.example.smup.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.smup.R
import com.example.smup.databinding.FragmentMyPageBinding
import com.example.smup.databinding.FragmentScheduleBinding
import java.util.*

class ScheduleFragment : Fragment() {

    private var CurrentProgress = 0
    private var progressBar: ProgressBar? = null
    private var mBinding : FragmentScheduleBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentScheduleBinding.inflate(inflater,container,false)
        val view = binding.root
        val binding = FragmentScheduleBinding.bind(view)

        progressBar = binding.circleProgressbar

        val timer = Timer()
        val timerTask: TimerTask = object : TimerTask(){
            override fun run() {
                CurrentProgress = CurrentProgress + 1
                progressBar!!.setProgress(CurrentProgress)
                progressBar!!.setMax(60)
                if(CurrentProgress>=60){
                    CurrentProgress = 0
                }
            }
        }
        timer.schedule(timerTask, 0, 1000)

        return view
    }

    companion object {

    }
}