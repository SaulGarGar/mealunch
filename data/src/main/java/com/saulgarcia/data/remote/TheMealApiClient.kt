package com.saulgarcia.data.remote

import com.saulgarcia.data.entity.response.GetMealsCategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface TheMealApiClient {
    @GET("categories.php")
    fun getMealCategories(): Call<GetMealsCategoryResponse>
}