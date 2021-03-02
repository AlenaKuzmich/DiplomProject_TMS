package by.alena.diplomproject.ViewModel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.alena.diplomproject.RemoteModel.Drinks
import by.alena.diplomproject.RemoteModel.MyCoctails
import by.alena.diplomproject.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoctailsViewModel (val repository: Repository) : ViewModel() {
    val scope = CoroutineScope(Dispatchers.IO)
    var selectedCoctails: Drinks? = null        //сохранение выбранного коктейля из первого фрагмента для перехода во второй фрагмент через вьюмодель

    val coctailsLive: MutableLiveData<MutableList<Drinks>> by lazy {
        MutableLiveData<MutableList<Drinks>>()
    }

    fun getData() {
        scope.launch {
            val data = repository.getData()
            Log.d("!!!vm", data.toString())
            coctailsLive.postValue(data)
        }
    }

}