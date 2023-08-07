package com.saulgarcia.domain.useCase

import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.repository.MealsCategoryRepository
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(private val mealsRepository: MealsCategoryRepository) {
     operator fun invoke(categoryName: String): Either {
        return mealsRepository.getMealsByCategory(categoryName)
    }
}