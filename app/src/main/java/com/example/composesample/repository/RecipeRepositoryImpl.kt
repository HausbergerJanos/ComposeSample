package com.example.composesample.repository

import com.example.composesample.domain.model.Recipe
import com.example.composesample.network.RecipeService
import com.example.composesample.network.model.RecipeDTOMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDTOMapper
) : RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token = token, id))
    }
}