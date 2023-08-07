package com.saulgarcia.data.di

import com.saulgarcia.data.remote.repository.MealsCategoryRepositoryImpl
import com.saulgarcia.domain.repository.MealsCategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideMealsCategoryRepository(
        mealsCategoryRepositoryImpl: MealsCategoryRepositoryImpl
    ): MealsCategoryRepository
}