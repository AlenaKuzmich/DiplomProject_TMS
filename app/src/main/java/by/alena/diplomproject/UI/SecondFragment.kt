package by.alena.diplomproject.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.alena.diplomproject.R
import by.alena.diplomproject.ViewModel.CoctailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.coctail_layout.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var viewModel: CoctailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as MainActivity).get(CoctailsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        viewModel.selectedCoctails?.let {
            Picasso.get().load(it.strDrinkThumb).into(imgSecond)
            nameText.text = it.strDrink
            receptBody.text = it.strInstructions
        }
    }


}