package com.saulgarcia.mealunch.features.mealsListView

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.saulgarcia.domain.entity.dataEntity.ShortMeal
import com.saulgarcia.mealunch.navigation.Routes

@Composable
fun MealsCell(meal: ShortMeal, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(
                    route = Routes.MealDetailsScreen.createRoute(mealId = meal.id ?: 0)
                )
            }
    ) {
        AsyncImage(
            model = meal.imageUrl,
            "Meal image",
            modifier = Modifier
                .size(60.dp)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(8.dp)
        )
        Spacer(
            modifier = Modifier
                .padding(4.dp)
        )
        meal.name?.let {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterVertically),
                text = it,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
        } ?: Text(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically),
            text = "Meals",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium
        )
    }
}