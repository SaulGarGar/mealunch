package com.saulgarcia.domain.repository

import com.saulgarcia.domain.entity.action.Either

interface MealsCategoryRepository {
    fun getMealsCategories(): Either
}