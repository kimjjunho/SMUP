package com.example.smup.feature.home.meal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smup.data.home.MealRepository

class MealViewModel (
    private val rp: MealRepository
): ViewModel(){
    
    val breakfast : MutableLiveData<String> = MutableLiveData()
    val lunch : MutableLiveData<String> = MutableLiveData()
    val dinner : MutableLiveData<String> = MutableLiveData()


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
}