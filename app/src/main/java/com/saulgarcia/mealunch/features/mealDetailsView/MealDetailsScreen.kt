package com.saulgarcia.mealunch.features.mealDetailsView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.saulgarcia.domain.entity.dataEntity.FullMeal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealDetailsScreen(navController: NavController, mealId: Int?) {
    val viewModel: MealDetailsViewModel = hiltViewModel()
    val mealDetails = viewModel.mealDetails.observeAsState(FullMeal())

    viewModel.getMealDetails(mealId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(mealDetails.value.name ?: "")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White
                )
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val painter = rememberAsyncImagePainter(model = mealDetails.value.imageUrl)
            Image(
                painter = painter,
                contentDescription = "Image of ${mealDetails.value.name}",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = mealDetails.value.category ?: "",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = mealDetails.value.area ?: "", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Ingredients", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            mealDetails.value.ingredients.zip(mealDetails.value.measures)
                .forEach { (ingredient, measure) ->
                    Text(text = "$ingredient: $measure", style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Instructions", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = mealDetails.value.instructions ?: "",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}