package com.saulgarcia.data.remote.mapper

import com.saulgarcia.data.remote.entity.dto.MealDto
import com.saulgarcia.domain.entity.action.Meal

fun MealDto.toMeal() = Meal(
    name = name,
    image = image,
    id = id
)