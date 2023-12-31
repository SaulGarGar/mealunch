package com.saulgarcia.data.remote.mapper

import com.saulgarcia.data.remote.entity.dto.MealsCategoryDto
import com.saulgarcia.domain.entity.dataEntity.MealsCategory

fun MealsCategoryDto.toMealsCategory() = MealsCategory(
    id = id,
    name = name,
    imageUrl = imageUrl,
    description = description
)