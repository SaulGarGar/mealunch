package com.saulgarcia.mealunch.features.mealsListView

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsListScreen(
    navController: NavController,
    categorySelected: String?
) {
    val viewModel: MealsListViewModel = hiltViewModel()
    val mealsList = viewModel.mealsList.observeAsState(initial = emptyList())

    viewModel.getMealsCategories(categorySelected)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(categorySelected ?: "")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White
                )
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(mealsList.value) { meal ->
                MealsCell(meal, navController = navController)
            }
        }
    }
}