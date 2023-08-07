package com.saulgarcia.mealunch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.saulgarcia.mealunch.ui.theme.MealunchTheme
import dagger.hilt.android.AndroidEntryPoint
import com.saulgarcia.mealunch.navigation.AppNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealunchTheme {
                MyActivityUi()
            }
        }
    }

    @Composable
    fun MyActivityUi() {
        AppNavigation()
    }
}
