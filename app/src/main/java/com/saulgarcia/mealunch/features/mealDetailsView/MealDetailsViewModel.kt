package com.saulgarcia.mealunch.features.mealDetailsView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.entity.dataEntity.FullMeal
import com.saulgarcia.domain.useCase.GetMealDetailsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val getMealDetailsByIdUseCase: GetMealDetailsByIdUseCase,
    private val coroutineContext: CoroutineContext
) : ViewModel() {

    private val _mealDetails: MutableLiveData<FullMeal> = MutableLiveData()
    val mealDetails: LiveData<FullMeal> get() = _mealDetails

    fun getMealDetails(mealId: Int?) {
        viewModelScope.launch(coroutineContext) {
            val result = getMealDetailsByIdUseCase(mealId ?: 0)
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Success -> {
                        _mealDetails.value = result.getData()
                    }

                    is Either.Error -> {
                        result.error
                    }
                }
            }
        }
    }
}

