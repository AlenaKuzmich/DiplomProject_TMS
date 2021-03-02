package by.alena.diplomproject.UI

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.alena.diplomproject.LocalModel.YourCoctails
import by.alena.diplomproject.R
import kotlinx.android.synthetic.main.fragment_your_coctail_recept.*

class YourCoctailReceptFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var yourCoctails: MutableList<YourCoctails>
    val CAMERA_REQUEST = 20
    lateinit var bmp: Bitmap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_your_coctail_recept, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()


        imageYourCoctail.setOnClickListener{
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST)
        }

        btnAdd.setOnClickListener{
            val yourCoctail = YourCoctails(
                titleYourCoctail.text.toString(),
                recipeYourCoctail.text.toString(),bmp
            )
        yourCoctails.add(yourCoctail)
        navController.popBackStack()
        }

    }

}