package by.alena.diplomproject.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.alena.diplomproject.R
import by.alena.diplomproject.RemoteModel.RemoteModel
import by.alena.diplomproject.Repository.Repository
import by.alena.diplomproject.ViewModel.CoctailsViewModel
import by.alena.diplomproject.ViewModel.CoctailsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

  lateinit var navController: NavController
  lateinit var viewModel: CoctailsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navController = findNavController(R.id.navHost)
        setupActionBarWithNavController(navController,drawer_layout)
        toolbar.setupWithNavController(navController,drawer_layout)

        nav_view.setupWithNavController(navController)

        val remoteModel = RemoteModel()
//        val localModel = LocalModel(this)
        val repository = Repository(remoteModel)
        val factory = CoctailsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(CoctailsViewModel::class.java)
//        viewModel.coctailsLive.setValue(mutableListOf())
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {            //
        MenuInflater(this).inflate(R.menu.main_menu,menu)        //три точечки справа вверху
        return true                                                     //
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(item, navController) ||
        super.onOptionsItemSelected(item)
    }
}