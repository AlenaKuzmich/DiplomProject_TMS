package by.alena.diplomproject.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.alena.diplomproject.LocalModel.YourCoctails
import by.alena.diplomproject.R

class YourCoctailsAdapter (val yourCoctailsList: MutableList<YourCoctails>, val fragment: ListYourCoctailsFragment): RecyclerView.Adapter<YourCoctailsAdapter.YourCoctailsViewHolder>(){
    class YourCoctailsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textTitle = itemView.findViewById<TextView>(R.id.titleYourCoctail)
        val textRecipe = itemView.findViewById<TextView>(R.id.recipeYourCoctail)
        val img = itemView.findViewById<ImageView>(R.id.imgCoctail)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourCoctailsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        val holder = YourCoctailsViewHolder(itemView)
        itemView.setOnClickListener{
            val position = holder.adapterPosition
            fragment.onYourCoctailsClick(position)      //   !функция пока не добавлена!
        }
        return holder
    }

    override fun getItemCount(): Int {      //длина нашего списка
        return yourCoctailsList.size
    }

    override fun onBindViewHolder(holder: YourCoctailsViewHolder, position: Int) {
        holder.textTitle.text = yourCoctailsList[position].title
        holder.textRecipe.text = yourCoctailsList[position].recipe
        holder.img.setImageBitmap(yourCoctailsList[position].photoRes)
    }
}