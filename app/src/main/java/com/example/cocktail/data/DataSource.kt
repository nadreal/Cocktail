package com.example.cocktail.data

import com.example.cocktail.R
import com.example.cocktail.model.Cocktail


/**
 * An object to generate a static list of dogs
 */
object DataSource {

    val cocktail: List<Cocktail> = listOf(
        Cocktail(
            R.drawable.ic_launcher_background,
            "Margharita",
            "7"

        ),
        Cocktail(
            R.drawable.ic_launcher_background,
            "Blue Lagune",
            "4"
        ),
        Cocktail(
            R.drawable.ic_launcher_background,
            "Dest",
            "2"
        ),
    )
}
