package com.saulgarcia.data.remote.entity.dto

import com.google.gson.annotations.SerializedName

data class MealsCategoryDto(
    @SerializedName("idCategory")
    val id: Int? = null,
    @SerializedName("strCategory")
    val name: String? = null,
    @SerializedName("strCategoryThumb")
    val imageUrl: String? = null,
    @SerializedName("strCategoryDescription")
    val description: String? = null
)
