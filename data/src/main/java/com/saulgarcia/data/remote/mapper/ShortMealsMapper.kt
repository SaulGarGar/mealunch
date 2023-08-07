package com.saulgarcia.data.remote.mapper

import com.saulgarcia.data.remote.entity.dto.ShortMealDto
import com.saulgarcia.domain.entity.dataEntity.ShortMeal

fun ShortMealDto.toShortMeal() = ShortMeal(
    name = name,
    imageUrl = imageUrl,
    id = id
)