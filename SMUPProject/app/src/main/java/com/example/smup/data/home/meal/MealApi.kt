package com.example.smup.data.home.meal

import com.example.smup.feature.home.meal.model.MealResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("meal/today")
    fun getTodayMeal(
    ) : Single<Response<MealResponse>>

    @GET("meal")
    fun getMeal(
        @Query("date") date : String
    ) : Single<Response<MealResponse>>

}