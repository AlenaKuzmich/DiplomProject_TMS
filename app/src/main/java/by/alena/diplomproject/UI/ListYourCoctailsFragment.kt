package by.alena.diplomproject.UI

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.alena.diplomproject.LocalModel.YourCoctails
import by.alena.diplomproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.coctail_layout.*
import kotlinx.android.synthetic.main.fragment_list_your_coctails.*
import kotlinx.android.synthetic.main.fragment_your_coctail_recept.*
import kotlinx.android.synthetic.main.nav_header.*

class ListYourCoctailsFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var yourCoctails: MutableList<YourCoctails>
    lateinit var yourCoctailsAdapter: YourCoctailsAdapter
    val CAMERA_REQUEST = 20
    lateinit var bmp: Bitmap


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_your_coctails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()


        yourCoctails = mutableListOf(
//            YourCoctails("Woo woo", "Mix vodka, peach schnapps, cranberry juice and fresh lime to make this perfect party cocktail, garnished with a lime wedge (and maybe a tiny umbrella too)")
        )


        yourCoctailsAdapter = YourCoctailsAdapter(yourCoctails, ListYourCoctailsFragment())
        recycleViewYourCoctail.adapter = yourCoctailsAdapter
        recycleViewYourCoctail.layoutManager = LinearLayoutManager(activity)
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
                bmp = data?.extras?.get("data") as Bitmap
                imageYourCoctail.setImageBitmap(bmp)
            }
        }


        fun onYourCoctailsClick(position: Int) {
            Toast.makeText(context, yourCoctails[position].title, Toast.LENGTH_LONG).show()
        }

        fun deleteYourCoctail(view: View) {
            if (yourCoctails.size > 0) {
                yourCoctails.removeAt(yourCoctails.size - 1)
                yourCoctailsAdapter.notifyDataSetChanged()   //говорит что источник изменился и вью нужно изменить
            }
        }
    }

