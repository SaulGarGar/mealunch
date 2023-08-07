package com.saulgarcia.data.remote.entity.response

import com.google.gson.annotations.SerializedName
import com.saulgarcia.data.remote.entity.dto.MealDto

data class GetMealsByCategoryResponse(
    @SerializedName("meals")
    val meals: List<MealDto> = listOf()
)
