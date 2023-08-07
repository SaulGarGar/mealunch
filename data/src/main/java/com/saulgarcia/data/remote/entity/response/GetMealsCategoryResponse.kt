package com.saulgarcia.data.remote.entity.response

import com.google.gson.annotations.SerializedName
import com.saulgarcia.data.remote.entity.dto.MealsCategoryDto

data class GetMealsCategoryResponse(
    @SerializedName("categories")
    val mealsCategories: List<MealsCategoryDto> = listOf()
)
