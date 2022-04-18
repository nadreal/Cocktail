package com.example.cocktail.network
import com.squareup.moshi.Json

data class CocktailPhoto(
    val id: String, @Json(name = "idDrink") val imgSrcUrl: String
)