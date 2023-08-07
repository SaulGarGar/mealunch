package com.saulgarcia.mealunch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saulgarcia.domain.entity.dataEntity.MealsCategory
import com.saulgarcia.mealunch.ui.categoryView.CategoryCell
import com.saulgarcia.mealunch.ui.categoryView.CategoryViewModel
import com.saulgarcia.mealunch.ui.theme.MealunchTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val categoryViewModel: CategoryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealunchTheme {
                MyActivityUi()
            }
        }
        categoryViewModel.getMealsCategories()
    }

    @Composable
    fun MyActivityUi(){
        val categoryList = categoryViewModel.categoryList.observeAsState(initial = emptyList())
        CategoryList(categoryList.value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryList(categoryList: List<MealsCategory>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Categories")
                }
            )
        },
    ) { padding ->
        LazyColumn (
            modifier = Modifier.padding(padding)
        ){
            items(categoryList) { category ->
                CategoryCell(category)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CategoryListDefaultPreview() {
    MealunchTheme {
        CategoryList(listOf(
            MealsCategory(
            id = 1,
            imageUrl = "",
            name = "Tacos",
            description = "I love tacos"
            ),
            MealsCategory(
                id = 1,
                imageUrl = "",
                name = "Tacos",
                description = "I love tacos"
            ),
            MealsCategory(
                id = 1,
                imageUrl = "",
                name = "Tacos",
                description = "I love tacos"
            ),
        ))
    }
}