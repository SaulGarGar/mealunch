package com.saulgarcia.domain.repository

import com.saulgarcia.domain.entity.action.Either
interface MealsCategoryRepository {
    fun getMealsCategories(): Either
    fun getMealsByCategory(categoryName: String): Either
    fun getMealDetailsById(mealId: Int): Either
}