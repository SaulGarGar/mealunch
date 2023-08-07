package com.saulgarcia.domain.useCase

import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.repository.MealsCategoryRepository
import javax.inject.Inject

class GetMealDetailsByIdUseCase @Inject constructor(private val mealsRepository: MealsCategoryRepository) {
    operator fun invoke(mealId: Int): Either {
        return mealsRepository.getMealDetailsById(mealId)
    }
}