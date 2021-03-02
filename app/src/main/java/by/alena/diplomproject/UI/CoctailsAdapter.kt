package by.alena.diplomproject.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.alena.diplomproject.R
import by.alena.diplomproject.RemoteModel.Drinks
import com.squareup.picasso.Picasso


class CoctailsAdapter (val coctails: MutableList<Drinks>, val fragment: FirstFragment):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.coctail_layout, parent, false)
        val holder = MyViewHolder(itemView)
        holder.itemView.setOnClickListener{
            fragment.onCoctailsSelect(holder.adapterPosition)   //чтобы открыть из первого фрагмента второй фрагмент по нажатию на коктейль
        }
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.drink.text = coctails[position].strDrink
        holder.category.text = coctails[position].strCategory
        holder.glass.text = coctails[position].strGlass
        Picasso.get().load(coctails[position].strDrinkThumb).into(holder.img)
    }

    override fun getItemCount(): Int {
      return  coctails.size
    }
}

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val drink = itemView.findViewById<TextView>(R.id.strDrink)
    val category = itemView.findViewById<TextView>(R.id.strCategory)
    val glass = itemView.findViewById<TextView>(R.id.strGlass)
    val img = itemView.findViewById<ImageView>(R.id.imgCoctail)
}

