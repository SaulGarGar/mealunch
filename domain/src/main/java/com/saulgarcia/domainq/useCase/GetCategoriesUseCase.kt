package com.saulgarcia.domainq.useCase

import com.saulgarcia.domainq.entity.action.Either
import com.saulgarcia.domainq.repository.MealsCategoryRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val mealsRepository: MealsCategoryRepository){
    fun invoke(): Either {
        return mealsRepository.getMealsCategories()
    }
}