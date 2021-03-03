package com.example.composesample.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composesample.domain.model.Recipe
import com.example.composesample.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Named

class RecipeListViewModel
@ViewModelInject
constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val authToken: String
) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    init {
        newSearch()
    }

    private fun newSearch() {
        viewModelScope.launch() {
            val result = repository.search(
                token = authToken,
                page = 1,
                query = "Chicken"
            )
            recipes.value = result
        }
    }
}