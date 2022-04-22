package com.example.cocktail.network

import com.example.cocktail.model.Cocktail
import com.example.cocktail.model.Cocktails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php")
//    fun getDrinks(@Query("f") f: String): Call<Cocktails>
    fun getDrinks(@Query("f") f: String): Call<Result<Cocktails>>
}