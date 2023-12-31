package com.saulgarcia.mealunch.navigation

sealed class Routes(val route: String) {
    object CategoryListScreen : Routes("category_list_screen")

    object MealsListScreen : Routes("meals_list_screen/{categoryName}") {
        fun createRoute(categoryName: String) = "meals_list_screen/$categoryName"
    }

    object MealDetailsScreen : Routes("meal_details_screen/{mealId}") {
        fun createRoute(mealId: Int) = "meal_details_screen/$mealId"
    }
}