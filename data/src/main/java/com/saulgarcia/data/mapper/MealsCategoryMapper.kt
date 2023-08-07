package com.saulgarcia.data.mapper

import com.saulgarcia.data.entity.dto.MealsCategoryDto
import com.saulgarcia.domain.entity.MealsCategory
import com.saulgarcia.data.entity.response.GetMealsCategoryResponse

fun MealsCategoryDto.toMealsCategory() = MealsCategory(
    id = id,
    name = name,
    imageUrl = imageUrl,
    description = description
)