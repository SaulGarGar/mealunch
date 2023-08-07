package com.saulgarcia.mealunch.ui.categoryView

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulgarcia.domain.entity.dataEntity.MealsCategory
import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.entity.dataEntity.FullMeal
import com.saulgarcia.domain.useCase.GetCategoriesUseCase
import com.saulgarcia.domain.useCase.GetMealDetailsByIdUseCase
import com.saulgarcia.domain.useCase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealsUseCase: GetMealsUseCase,
    private val getMealDetailsByIdUseCase: GetMealDetailsByIdUseCase,
    private val coroutineContext: CoroutineContext
):  ViewModel() {

    private val _categoryListMLD: MutableLiveData<List<MealsCategory>> = MutableLiveData()
    val categoryList: LiveData<List<MealsCategory>> get() = _categoryListMLD
    fun getMealsCategories(){
        viewModelScope.launch(coroutineContext) {
            val result = getCategoriesUseCase()
            withContext(Dispatchers.Main){
                when (result) {
                    is Either.Success -> {
                        _categoryListMLD.value = result.getData()
                    }
                    is Either.Error -> {
                        result.error
                    }
                }
            }
        }
    }
}