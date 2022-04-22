package com.example.cocktail.CocktailAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktail.R
import com.example.cocktail.model.Cocktail
import com.example.cocktail.model.Cocktails
import com.example.cocktail.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CocktailCardAdapter(
    private val context: Context?, var mCoctails: MutableList<Cocktail>
): RecyclerView.Adapter<CocktailCardAdapter.CocktailCardViewHolder>() {

    class CocktailCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val cocktailName: TextView = view?.findViewById(R.id.cocktail_name)!!
        val cocktailGlassType: TextView = view?.findViewById(R.id.cocktail_glass)!!
        val cocktailImage: ImageView = view?.findViewById(R.id.cocktail_image)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailCardViewHolder {
        return CocktailCardViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.vertical_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mCoctails.size
//        return 5
    }

    override fun onBindViewHolder(
        holder: CocktailCardAdapter.CocktailCardViewHolder, position: Int) {
        holder.cocktailName.text = mCoctails?.get(position).toString()
    }


}


