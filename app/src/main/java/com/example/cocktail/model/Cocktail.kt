package com.example.cocktail.model

import androidx.annotation.DrawableRes

data class Cocktail (
    @DrawableRes
    val imageResourceId: Int,
    val name: String,
    val glasstype: String

)