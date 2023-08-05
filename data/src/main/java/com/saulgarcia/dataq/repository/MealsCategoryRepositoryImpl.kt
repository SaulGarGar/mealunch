package com.saulgarcia.dataq.repository

import com.saulgarcia.domainq.entity.action.Either
import com.saulgarcia.domainq.entity.action.error.ErrorEntity
import com.saulgarcia.dataq.mapper.toMealsCategory
import com.saulgarcia.dataq.remote.TheMealApiClient
import com.saulgarcia.domainq.repository.MealsCategoryRepository
import javax.inject.Inject

class MealsCategoryRepositoryImpl @Inject constructor (private val client: TheMealApiClient):
    MealsCategoryRepository {
    override fun getMealsCategories(): Either = try {
        val response = client.getMealCategories().execute()
        if (response.isSuccessful) {
            response.body()?.let { body ->
                Either.Success (body.toMealsCategory())
            } ?: Either.Error(ErrorEntity.EmptyResponseError)
        } else {
            Either.Error(ErrorEntity.NetworkError(response.code()))
        }
    } catch (e: Exception) {
        Either.Error(ErrorEntity.UnknownError(e))
    }
}