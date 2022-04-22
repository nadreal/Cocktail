package com.example.cocktail.model

abstract class Cocktails(override val size: Int) : MutableList<Cocktail> {
    var cocktails: List<Cocktail>? = null 
}