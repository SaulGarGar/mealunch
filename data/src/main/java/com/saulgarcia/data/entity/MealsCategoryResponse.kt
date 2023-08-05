package com.saulgarcia.data.entity

import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse(
    @SerializedName("idCategory")
    val id: Int? = null,
    @SerializedName("strCategory")
    val name: String? = null,
    @SerializedName("strCategoryThumb")
    val imageUrl: String? = null,
    @SerializedName("strCategoryDescription")
    val description: String? = null
)
