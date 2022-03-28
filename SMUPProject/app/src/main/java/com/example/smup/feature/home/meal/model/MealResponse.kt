package com.example.smup.feature.home.meal.model

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("breakfast") val breakfast : String,
    @SerializedName("dinner") val dinner : String,
    @SerializedName("lunch") val lunch : String
)