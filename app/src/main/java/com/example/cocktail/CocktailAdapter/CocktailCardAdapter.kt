package com.example.cocktail.CocktailAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktail.R
import com.example.cocktail.data.DataSource
import com.example.cocktail.data.DataSource.cocktail
import com.example.cocktail.model.Cocktail


class CocktailCardAdapter (
    private val context: Context?,

): RecyclerView.Adapter<CocktailCardAdapter.CocktailCardViewHolder>() {
    val dogs: List<Cocktail> = DataSource.cocktail

    /**
     * Initialize view elements
     */
    class CocktailCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val cocktailName: TextView = view?.findViewById(R.id.dog_name)!!
        val cocktailGlassType: TextView = view?.findViewById(R.id.dog_age)!!
        val cocktailImage: ImageView = view?.findViewById(R.id.iw_image)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailCardViewHolder {
        var adapterLayout: View =
            LayoutInflater.from(parent.context).inflate(R.layout.vertical_list_item, parent, false)
        adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_list_item, parent, false)
               return CocktailCardViewHolder(adapterLayout)
        }


    override fun getItemCount(): Int = cocktail.size

    override fun onBindViewHolder(holder: CocktailCardAdapter.CocktailCardViewHolder, position: Int) {
        val cocktail = cocktail[position]
        println(cocktail.name)
        println(cocktail.glasstype)
        val resources = context?.resources

        holder.cocktailImage.setImageResource(cocktail.imageResourceId)
        holder.cocktailName.text = resources?.getString(R.string.Cocktail_name,cocktail.name)
        holder.cocktailGlassType.text = resources?.getString(R.string.Cocktail_glass_type, cocktail.glasstype)

    }
}
