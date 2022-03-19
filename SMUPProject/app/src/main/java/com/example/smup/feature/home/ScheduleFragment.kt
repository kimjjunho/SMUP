package com.example.smup.feature.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.smup.databinding.FragmentScheduleBinding
import java.text.SimpleDateFormat
import java.util.*

class ScheduleFragment : Fragment() {

    private var progressBar: ProgressBar? = null
    private var progress = 0
    private var rotaion = 0F
    private var time = ""
    private var mBinding : FragmentScheduleBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentScheduleBinding.inflate(inflater,container,false)
        val view = binding.root
        val binding = FragmentScheduleBinding.bind(view)

        getTime()
        val iTime = time.toInt()
        println(iTime-(iTime/100*100))
        if(iTime-(iTime/100*100)+45>=60){
            timeSolve(iTime/100,iTime-(iTime/100*100), iTime/100+1, iTime-(iTime/100*100)+45-60)
        }else{
            timeSolve(iTime/100,iTime-(iTime/100*100), iTime/100, iTime-(iTime/100*100)+45)
        }

        progressBar = binding.circleProgressbar
        progressBar!!.rotation = rotaion
        progressBar!!.progress = progress

        return view
    }

    fun timeSolve(sHour1 : Int, sMin1 : Int, eHour1 : Int, eMin1 : Int){
        var sHour = 0.0F
        var sMin = 0F
        var eHour = 0
        var eMin = 0
        var total = 0.0

        sHour = if(sHour1<3){ (sHour1+9)*30F }
        else{ (sHour1 - 3)*30F }

        sMin = 0.5F * sMin1
        rotaion = sHour + sMin

        if(sMin1>eMin1){
            eMin = eMin1 + 60 - sMin1
            eHour = eHour1 - sHour1 - 1
            total = eMin * 0.14 + eHour * 8.3
            progress = total.toInt()
        }else{
            eMin = eMin1 - sMin1
            eHour = eHour1 - sHour1
            total = eMin * 0.14 + eHour * 8.3
            progress = total.toInt()
        }
    }

    fun getTime(){
        val now = System.currentTimeMillis()
        val date = Date(now)
        val dateFormat = SimpleDateFormat("hhmm")
        val getTime = dateFormat.format(date)
        time = getTime
    }

    companion object {

    }
}