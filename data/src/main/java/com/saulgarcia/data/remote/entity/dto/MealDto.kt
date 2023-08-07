package com.saulgarcia.data.remote.entity.dto

import com.google.gson.annotations.SerializedName

data class MealDto(
    @SerializedName("strMeal")
    val name: String? = null,
    @SerializedName("strMealThumb")
    val image: String? = null,
    @SerializedName("idMeal")
    val id: Int? = null,
)
