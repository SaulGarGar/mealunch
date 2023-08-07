package com.saulgarcia.mealunch.features.mealsListView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.entity.dataEntity.ShortMeal
import com.saulgarcia.domain.useCase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MealsListViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase,
    private val coroutineContext: CoroutineContext
) : ViewModel() {
    private val _mealsList: MutableLiveData<List<ShortMeal>> = MutableLiveData()
    val mealsList: LiveData<List<ShortMeal>> get() = _mealsList

    fun getMealsCategories(categorySelected: String?) {
        viewModelScope.launch(coroutineContext) {
            val result = getMealsUseCase(categorySelected ?: "")
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Success -> {
                        _mealsList.value = result.getData()
                    }

                    is Either.Error -> {
                        result.error
                    }
                }
            }
        }
    }
}