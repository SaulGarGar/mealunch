package com.saulgarcia.mealunch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.saulgarcia.mealunch.features.categoryListView.CategoryListScreen
import com.saulgarcia.mealunch.features.mealDetailsView.MealDetailsScreen
import com.saulgarcia.mealunch.features.mealsListView.MealsListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.CategoryListScreen.route) {
        composable(route = Routes.CategoryListScreen.route) {
            CategoryListScreen(navController = navController)
        }
        composable(
            route = Routes.MealsListScreen.route,
            arguments = listOf(navArgument(name = "categoryName") {
                type = NavType.StringType
            })
        ) {
            MealsListScreen(
                navController = navController, it.arguments?.getString("categoryName")
            )
        }
        composable(
            route = Routes.MealDetailsScreen.route,
            arguments = listOf(navArgument(name = "mealId") {
                type = NavType.IntType
            })
        ) {
            MealDetailsScreen(
                navController = navController, it.arguments?.getInt("mealId")
            )
        }
    }
}