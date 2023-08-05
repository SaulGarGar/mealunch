package com.saulgarcia.data.mapper

import com.saulgarcia.domain.entity.MealsCategory
import com.saulgarcia.data.entity.MealsCategoryResponse

fun MealsCategoryResponse.toMealsCategory() = MealsCategory(
    id = id,
    name = name,
    imageUrl = imageUrl,
    description = description
)