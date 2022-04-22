package com.example.cocktail


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktail.CocktailAdapter.CocktailCardAdapter
import com.example.cocktail.databinding.ActivityMainBinding
import com.example.cocktail.model.Cocktail
import com.example.cocktail.model.Cocktails

import com.example.cocktail.network.HttpHelper
import com.example.cocktail.network.Result
import com.example.cocktail.network.SingleCallback


class MainActivity : AppCompatActivity() {

    private var mCocktailList: MutableList<Cocktail> = ArrayList()
    private var rvCocktailsData: RecyclerView? = null
//  private  var mCocktails = Cocktails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCocktailsData = findViewById(R.id.vertical_recycler_view)
        rvCocktailsData?.layoutManager = LinearLayoutManager(this)
        rvCocktailsData?.adapter = CocktailCardAdapter(this, mCocktailList)

        loadDrinksStartingOn("a")
    }

    private fun loadDrinksStartingOn(letter: String) {
        var api = HttpHelper.getApi()
        var call = api?.getDrinks(letter)

        call!!.enqueue(object : SingleCallback<Result<Cocktails>>(){
            override fun onSuccess(response: Result<Cocktails>) {
                if (response.data != null && response.data?.cocktails != null && response.data?.cocktails?.size ?: 0 > 0) {
                    mCocktailList.addAll(response.data?.cocktails!!)
                    rvCocktailsData?.adapter?.notifyDataSetChanged()
                }
            }

        })
    }



//    private fun loadDrinksStartingOn1(letter: String) {
//        val adapter = Retrofit.Builder()
//            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val api = adapter.create(ApiService::class.java)
//        val call = api.getDrinks(letter)
//        call.enqueue(object : Callback<Cocktails?> {
//            override fun onResponse(call: Call<Cocktails?>, response: Response<Cocktails?>) {
//                if (response.body() != null) {
//                    mCocktailList = response.body()!!
//                    binding?.verticalRecyclerView?.adapter?.notifyDataSetChanged()
//                    // Todo save them in prefs or db for offline use
//                }
//            }//
//            override fun onFailure(call: Call<Cocktails?>, t: Throwable) {//
//                Log.d("Error ~ Can't get some data :(", t.message!!)
//            }
//        })
//        setContentView(binding!!.root)
//    }
}





