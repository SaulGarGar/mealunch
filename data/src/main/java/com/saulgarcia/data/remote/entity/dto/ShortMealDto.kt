package com.saulgarcia.data.remote.entity.dto

import com.google.gson.annotations.SerializedName

data class ShortMealDto(
    @SerializedName("strMeal")
    val name: String? = null,
    @SerializedName("strMealThumb")
    val imageUrl: String? = null,
    @SerializedName("idMeal")
    val id: Int? = null,
)
