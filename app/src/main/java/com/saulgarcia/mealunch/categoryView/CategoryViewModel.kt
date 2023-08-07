package com.saulgarcia.mealunch.categoryView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulgarcia.domain.entity.MealsCategory
import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.useCase.GetCategoriesUseCase
import com.saulgarcia.domain.useCase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealsUseCase: GetMealsUseCase,
    private val coroutineContext: CoroutineContext
):  ViewModel() {
    fun getMealsCategories(){
        viewModelScope.launch(coroutineContext) {
            when (val result = getMealsUseCase("Seafood")) {
                is Either.Success -> {
                    result.getData<List<MealsCategory>>()
                }
                is Either.Error -> {
                    result.error
                }
            }
        }
    }
}