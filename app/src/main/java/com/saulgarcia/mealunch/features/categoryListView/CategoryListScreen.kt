package com.saulgarcia.mealunch.features.categoryListView

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(navController: NavController) {
    val viewModel: CategoryListViewModel = hiltViewModel()
    val categoryList = viewModel.categoryList.observeAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Categories")
                }
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(categoryList.value){ category ->
                CategoryCell(category = category, navController = navController)
            }
        }
    }
}