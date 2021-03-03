package com.example.composesample.di

import com.example.composesample.network.RecipeService
import com.example.composesample.network.model.RecipeDTOMapper
import com.example.composesample.repository.RecipeRepository
import com.example.composesample.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDTOMapper: RecipeDTOMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeDTOMapper
        )
    }
}