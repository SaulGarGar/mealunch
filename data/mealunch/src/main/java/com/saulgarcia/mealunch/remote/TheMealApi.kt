package com.saulgarcia.mealunch.remote

import retrofit2.http.GET

interface TheMealApi {
    @GET("/categories.php")
    fun getAllCategories()
}