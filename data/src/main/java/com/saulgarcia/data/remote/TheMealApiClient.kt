package com.saulgarcia.data.remote

import com.saulgarcia.data.entity.MealsCategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface TheMealApiClient {
    @GET("categories.php")
    fun getMealCategories(): Call<MealsCategoryResponse>
}