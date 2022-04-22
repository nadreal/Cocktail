package com.example.cocktail.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class HttpHelper {
    companion object {
    private val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
    private var sApi: ApiService? = null

    fun getApi(): ApiService? {
        if (sApi == null) {
            synchronized(HttpHelper::class.java) {
                if (sApi == null) {
                    val retrofit = createRetrofit(BASE_URL)
                    sApi = retrofit.create(ApiService::class.java)
                }
            }
        }
        return sApi
    }

     private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
//            .client(getHttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
}