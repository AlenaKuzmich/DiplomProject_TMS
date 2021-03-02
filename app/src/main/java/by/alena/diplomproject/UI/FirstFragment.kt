package by.alena.diplomproject.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.alena.diplomproject.R
import by.alena.diplomproject.RemoteModel.Drinks
import by.alena.diplomproject.RemoteModel.MyCoctails
import by.alena.diplomproject.ViewModel.CoctailsViewModel
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var viewModel: CoctailsViewModel
    val coctails = mutableListOf<Drinks>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as MainActivity).get(CoctailsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()


        buttonGetData.setOnClickListener {
            imageInFirstFragment.visibility = View.GONE
            viewModel.getData()
        }

        viewModel.coctailsLive.observe(activity as MainActivity, Observer {
            Log.d("!!!",it.toString())
            coctails.clear()
            coctails.addAll(it)
            recyclerView.adapter?.notifyDataSetChanged()
        })

        val adapter = CoctailsAdapter(coctails,this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    fun onCoctailsSelect(position: Int) {
        viewModel.selectedCoctails = coctails[position]
        navController.navigate(R.id.secondFragment)
    }

}