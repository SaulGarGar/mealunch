package com.saulgarcia.domainq.repository

import com.saulgarcia.domainq.entity.action.Either

interface MealsCategoryRepository {
    fun getMealsCategories(): Either
}