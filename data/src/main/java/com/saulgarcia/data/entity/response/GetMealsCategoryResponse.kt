package com.saulgarcia.data.entity.response

import com.google.gson.annotations.SerializedName
import com.saulgarcia.data.entity.dto.MealsCategoryDto

data class GetMealsCategoryResponse(
    @SerializedName("categories")
    val mealsCategories: List<MealsCategoryDto> = listOf()
)
