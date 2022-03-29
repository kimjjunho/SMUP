package com.example.smup.feature.home.meal.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smup.data.home.MealRepository
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MealViewModel (
    private val rp: MealRepository
): ViewModel(){
    val TAG = "MealViewModel"

    val breakfast : MutableLiveData<String> = MutableLiveData()
    val lunch : MutableLiveData<String> = MutableLiveData()
    val dinner : MutableLiveData<String> = MutableLiveData()
    val date : MutableLiveData<String> = MutableLiveData()
    val day : MutableLiveData<String> = MutableLiveData()
    var click = 0


    fun getTodayMeal(){
        rp.getTodaymeal()
            .subscribe{response ->
                if(response.isSuccessful){
                    breakfast.value = response.body()?.breakfast.toString()
                    lunch.value = response.body()?.lunch.toString()
                    dinner.value = response.body()?.dinner.toString()
                }else{
                    breakfast.value = "오늘"
                    lunch.value = "급식은"
                    dinner.value = "와이파이"
                }
            }
    }

    fun getMeal(date : String){
        rp.getMeal(date)
            .subscribe{response->
                if(response.isSuccessful){
                    breakfast.value = response.body()?.breakfast.toString()
                    lunch.value = response.body()?.lunch.toString()
                    dinner.value = response.body()?.dinner.toString()
                }else{
                    breakfast.value = "오늘"
                    lunch.value = "급식은"
                    dinner.value = "와이파이"
                }
            }
    }

    fun dayData(){
        val cal = Calendar.getInstance()
        cal.time = Date()

        val df1: DateFormat = SimpleDateFormat("yyyyMMdd")
        cal.add(Calendar.DATE,click)

        val df2: DateFormat = SimpleDateFormat("yyyyMMdd")
        val date : Date = df2.parse(df1.format(cal.time))

        val df3:DateFormat = SimpleDateFormat("yyyy.MM.dd")

        val cal2 = Calendar.getInstance()
        cal2.time = date

        when(cal2.get(Calendar.DAY_OF_WEEK)){
            1-> day.value = "일"
            2-> day.value = "월"
            3-> day.value = "화"
            4-> day.value = "수"
            5-> day.value = "목"
            6-> day.value = "금"
            7-> day.value = "토"
        }

        this.date.value = df3.format(cal.time)
    }

    fun minusData(){
        click--
        dayData()
    }
    fun addData(){
        click++
        dayData()
    }
}