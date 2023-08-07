package com.saulgarcia.data.remote

import com.saulgarcia.data.remote.entity.response.GetAllMealsCategoriesResponse
import com.saulgarcia.data.remote.entity.response.GetMealDetailsByIdResponse
import com.saulgarcia.data.remote.entity.response.GetMealsByCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMealApiClient {
    @GET("categories.php")
    fun getMealCategories(): Call<GetAllMealsCategoriesResponse>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") categoryName: String): Call<GetMealsByCategoryResponse>

    @GET("lookup.php")
    fun getMealDetailsById(@Query("i") mealId: Int): Call<GetMealDetailsByIdResponse>
}