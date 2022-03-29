package com.example.smup.data.home

import com.example.smup.feature.home.meal.model.MealResponse
import com.example.smup.feature.mealApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MealRepository {
    fun login() : @NonNull Single<Response<MealResponse>>? =
        mealApi.getTodayMeal()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}