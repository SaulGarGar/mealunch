package com.saulgarcia.data.remote.repository

import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.entity.action.error.ErrorEntity
import com.saulgarcia.data.remote.mapper.toMealsCategory
import com.saulgarcia.data.remote.TheMealApiClient
import com.saulgarcia.data.remote.mapper.toMeal
import com.saulgarcia.domain.repository.MealsCategoryRepository
import javax.inject.Inject

class MealsCategoryRepositoryImpl @Inject constructor (private val client: TheMealApiClient):
    MealsCategoryRepository {
    override fun getMealsCategories(): Either = try {
        val response = client.getMealCategories().execute()
        if (response.isSuccessful) {
            response.body()?.let { body ->
                Either.Success(body.mealsCategories.map { it.toMealsCategory() })
            } ?: Either.Error(ErrorEntity.EmptyResponseError)
        } else {
            Either.Error(ErrorEntity.NetworkError(response.code()))
        }
    } catch (e: Exception) {
        Either.Error(ErrorEntity.UnknownError(e))
    }

    override fun getMealsByCategory(categoryName: String): Either = try {
        val response = client.getMealsByCategory(categoryName).execute()
        if (response.isSuccessful) {
            response.body()?.let { body ->
                Either.Success(body.meals.map { it.toMeal() })
            } ?: Either.Error(ErrorEntity.EmptyResponseError)
        } else {
            Either.Error(ErrorEntity.NetworkError(response.code()))
        }
    } catch (e: Exception) {
        Either.Error(ErrorEntity.UnknownError(e))
    }
}