package com.example.smup.feature.home.schedule.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smup.data.home.schedule.ScheduleRepository
import java.text.SimpleDateFormat
import java.util.*

class ScheduleViewModel(
    private val rp : ScheduleRepository
    ):ViewModel(){

    val progressTotal : MutableLiveData<String> = MutableLiveData()
    val rotaionTotal : MutableLiveData<String> = MutableLiveData()
    val timeTotal : MutableLiveData<String> = MutableLiveData()

    private var progress = 0
    private var rotaion = 0F
    private var time = ""

    fun schedule(){
        getTime()
        val iTime = time.toInt()
        if(iTime-(iTime/100*100)+45>=60){
            timeSolve(iTime/100,iTime-(iTime/100*100), iTime/100+1, iTime-(iTime/100*100)+45-60)
        }else{
            timeSolve(iTime/100,iTime-(iTime/100*100), iTime/100, iTime-(iTime/100*100)+45)
        }
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
        progressTotal.value = progress.toString()
        rotaionTotal.value = rotaion.toString()
    }

    fun getTime(){
        val now = System.currentTimeMillis()
        val date = Date(now)
        val dateFormat = SimpleDateFormat("hhmm")
        val getTime = dateFormat.format(date)
        time = getTime
    }

    fun setTime(){
        val cal = Calendar.getInstance()
        cal.time = Date()
        val format = SimpleDateFormat("HH:mm")

        timeTotal.value = format.format(cal.time).toString()
    }
}