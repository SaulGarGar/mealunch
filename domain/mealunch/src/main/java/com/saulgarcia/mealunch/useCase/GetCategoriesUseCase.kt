package com.saulgarcia.mealunch.useCase

import java.util.concurrent.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val mealsRepository: MealsRepository){
    suspend fun invoke(): Flow<MealsCategory>{
        return mealsRepository.getMealsCategories()
    }
}