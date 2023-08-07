package com.saulgarcia.mealunch.features.categoryListView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulgarcia.domain.entity.dataEntity.MealsCategory
import com.saulgarcia.domain.entity.action.Either
import com.saulgarcia.domain.useCase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val coroutineContext: CoroutineContext
) : ViewModel() {

    private val _categoryList: MutableLiveData<List<MealsCategory>> = MutableLiveData()
    val categoryList: LiveData<List<MealsCategory>> get() = _categoryList

    init {
        getMealsCategories()
    }

    private fun getMealsCategories() {
        viewModelScope.launch(coroutineContext) {
            val result = getCategoriesUseCase()
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Success -> {
                        _categoryList.value = result.getData()
                    }

                    is Either.Error -> {
                        result.error
                    }
                }
            }
        }
    }
}