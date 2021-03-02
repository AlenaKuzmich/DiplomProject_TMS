package by.alena.diplomproject.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.alena.diplomproject.Repository.Repository


@Suppress("UNCHECKED_CAST")
class CoctailsViewModelFactory(val repository: Repository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoctailsViewModel(repository) as T
    }
}
