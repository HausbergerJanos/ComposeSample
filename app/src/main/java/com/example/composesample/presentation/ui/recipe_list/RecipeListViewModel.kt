package com.example.composesample.presentation.ui.recipe_list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.composesample.repository.RecipeRepository
import javax.inject.Named

class RecipeListViewModel
@ViewModelInject
constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val authToken: String
) : ViewModel() {

    init {
        println("VIEW_MODEL: $repository")
        println("VIEW_MODEL: $authToken")
    }

    fun getRepo() = repository

    fun getAuthToken() = authToken
}