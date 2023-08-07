package com.saulgarcia.data.remote.entity.response

import com.google.gson.annotations.SerializedName
import com.saulgarcia.data.remote.entity.dto.FullMealDto

data class GetMealDetailsByIdResponse(
    @SerializedName("meals")
    val meals: List<FullMealDto> = listOf()
)
