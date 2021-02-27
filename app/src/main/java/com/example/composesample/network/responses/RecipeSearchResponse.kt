package com.example.composesample.network.responses

import com.example.composesample.network.model.RecipeNetworkEntity
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeNetworkEntity>
)