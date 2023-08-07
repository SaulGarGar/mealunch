package com.saulgarcia.data.remote.mapper

import com.saulgarcia.data.remote.entity.dto.FullMealDto
import com.saulgarcia.domain.entity.dataEntity.FullMeal

fun FullMealDto.toFullMeal() = FullMeal(
    id = id,
    name = name,
    drinkAlternate = drinkAlternate,
    category = category,
    area = area,
    instructions = instructions,
    imageUrl = imageUrl,
    tags = tags,
    youTubeVideoUrl = youTubeVideoUrl,
    ingredients = parseIngredients(this),
    measures = parseMeasures(this),
    source = source,
    imageSource = imageSource,
    creativeCommonsConfirmed = creativeCommonsConfirmed,
    dateModified = dateModified
)

private fun parseIngredients(fullMealDto: FullMealDto): List<String> {
    return listOfNotNull(
        fullMealDto.ingredient1,
        fullMealDto.ingredient2,
        fullMealDto.ingredient3,
        fullMealDto.ingredient4,
        fullMealDto.ingredient5,
        fullMealDto.ingredient6,
        fullMealDto.ingredient7,
        fullMealDto.ingredient8,
        fullMealDto.ingredient9,
        fullMealDto.ingredient10,
        fullMealDto.ingredient11,
        fullMealDto.ingredient12,
        fullMealDto.ingredient13,
        fullMealDto.ingredient14,
        fullMealDto.ingredient15,
        fullMealDto.ingredient16,
        fullMealDto.ingredient17,
        fullMealDto.ingredient18,
        fullMealDto.ingredient19,
        fullMealDto.ingredient20
    ).filter {
        it.isNotBlank()
    }
}

private fun parseMeasures(fullMealDto: FullMealDto): List<String> {
    return listOfNotNull(
        fullMealDto.measure1,
        fullMealDto.measure2,
        fullMealDto.measure3,
        fullMealDto.measure4,
        fullMealDto.measure5,
        fullMealDto.measure6,
        fullMealDto.measure7,
        fullMealDto.measure8,
        fullMealDto.measure9,
        fullMealDto.measure10,
        fullMealDto.measure11,
        fullMealDto.measure12,
        fullMealDto.measure13,
        fullMealDto.measure14,
        fullMealDto.measure15,
        fullMealDto.measure16,
        fullMealDto.measure17,
        fullMealDto.measure18,
        fullMealDto.measure19,
        fullMealDto.measure20
    ).filter {
        it.isNotBlank()
    }
}