package br.com.mvclopes.mygists.ui.list

import android.app.Application
import androidx.lifecycle.*
import br.com.mvclopes.mygists.database.getDataBase
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.repository.GistRepository
import kotlinx.coroutines.launch

class GistListViewModel(application: Application): AndroidViewModel(application) {

    private val database = getDataBase(application)
    private val repository = GistRepository(database)

    private var _gist = MutableLiveData<MutableList<GistItem>>()
    val gist: LiveData<MutableList<GistItem>> get() = _gist

    init {
        getPublicGists()
    }

    private fun getPublicGists(){
        viewModelScope.launch {
            _gist.value = repository.refreshGists()
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GistListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GistListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}