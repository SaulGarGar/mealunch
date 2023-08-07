package com.saulgarcia.mealunch.di

import com.saulgarcia.domain.useCase.GetCategoriesUseCase
import com.saulgarcia.domain.useCase.GetMealsUseCase
import com.saulgarcia.mealunch.di.CoroutineScopeModule.provideIOCoroutineContext
import com.saulgarcia.mealunch.features.categoryListView.CategoryListViewModel
import com.saulgarcia.mealunch.features.mealsListView.MealsListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {
    @Provides
    fun provideCategoryListViewModel(
        getCategoriesUseCase: GetCategoriesUseCase
        ): CategoryListViewModel {
        return CategoryListViewModel(getCategoriesUseCase, provideIOCoroutineContext())
    }

    @Provides
    fun provideMealsListViewModel(
        getMealsUseCase: GetMealsUseCase
    ): MealsListViewModel {
        return MealsListViewModel(getMealsUseCase, provideIOCoroutineContext())
    }
}