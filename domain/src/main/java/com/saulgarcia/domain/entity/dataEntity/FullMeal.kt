package com.saulgarcia.domain.entity.dataEntity

data class FullMeal(
    var id: String? = null,
    var name: String? = null,
    var drinkAlternate: String? = null,
    var category: String? = null,
    var area : String? = null,
    var instructions: String? = null,
    var imageUrl: String? = null,
    var tags: String? = null,
    var youTubeVideoUrl: String? = null,
    var ingredients: List<String> = listOf(),
    var measures: List<String> = listOf(),
    var source: String? = null,
    var imageSource: String? = null,
    var creativeCommonsConfirmed: String? = null,
    var dateModified: String? = null
)
