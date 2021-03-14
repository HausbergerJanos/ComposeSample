package com.example.composesample.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.composesample.R
import com.example.composesample.presentation.components.*
import com.example.composesample.presentation.components.HeartAnimDefinition.HeartButtonState.*
import com.example.composesample.util.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                val selectedCategory = viewModel.selectedCategory.value

                val loading = viewModel.loading.value

                Column {
                    SearchAppBar(
                        query = query,
                        onQueryChanged = viewModel::onQueryChanged,
                        onExecuteSearch = viewModel::newSearch,
                        scrollPosition = viewModel.categoryScrollPosition,
                        selectedCategory = selectedCategory,
                        onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                        onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        val state = remember { mutableStateOf(IDLE) }
                        AnimatedHearthButton(
                            modifier = Modifier,
                            buttonState = state,
                            onToggle = {
                                state.value = if (state.value == IDLE) ACTIVE else IDLE
                            }
                        )
                    }

                    //PulsingDemo()

//                    Box(
//                        modifier = Modifier.fillMaxSize()
//                    ) {
//                        LazyColumn {
//                            itemsIndexed(
//                                items = recipes
//                            ) { index, recipe ->
//                                RecipeCard(recipe = recipe, onClick = {})
//                            }
//                        }
//
//                        CircularIndeterminateProgressBar(isDisplayed = loading)
//                    }
                }
            }
        }
    }
}