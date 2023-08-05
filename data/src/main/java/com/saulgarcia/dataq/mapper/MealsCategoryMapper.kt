package com.saulgarcia.dataq.mapper

import com.saulgarcia.domainq.entity.MealsCategory
import com.saulgarcia.dataq.entity.MealsCategoryResponse

fun MealsCategoryResponse.toMealsCategory() = MealsCategory(id = id)