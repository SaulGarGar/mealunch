package com.saulgarcia.dataq.remote

import com.saulgarcia.dataq.entity.MealsCategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface TheMealApiClient {
    @GET("/categories.php")
    fun getMealCategories(): Call<MealsCategoryResponse>
}