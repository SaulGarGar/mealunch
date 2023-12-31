package com.saulgarcia.mealunch.features.categoryListView

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.saulgarcia.domain.entity.dataEntity.MealsCategory
import com.saulgarcia.mealunch.navigation.Routes

@Composable
fun CategoryCell(category: MealsCategory, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(
                    route = Routes.MealsListScreen.createRoute(category.name ?: "")
                )
            }
    ) {
        AsyncImage(
            model = category.imageUrl,
            "Category image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(8.dp)
        )
        Spacer(
            modifier = Modifier
                .padding(4.dp)
        )
        Column {
            category.name?.let {
                Text(
                    it,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
            }
            category.description?.let {
                Text(
                    it,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Light,
                    maxLines = 2
                )
            }
        }
    }
}