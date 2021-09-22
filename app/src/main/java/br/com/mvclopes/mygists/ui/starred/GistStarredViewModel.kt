package br.com.mvclopes.mygists.ui.starred

import android.app.Application
import androidx.lifecycle.*
import br.com.mvclopes.mygists.database.getDataBase
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.repository.GistRepository
import kotlinx.coroutines.launch

class GistStarredViewModel(application: Application): AndroidViewModel(application) {

    private val database = getDataBase(application)
    private val repository = GistRepository(database)

    private val _gistStarred = MutableLiveData<MutableList<GistItem>>()
    val gistStarred: LiveData<MutableList<GistItem>> get() = _gistStarred

    init {
        getStarredGist()
    }

    private fun getStarredGist(){
        viewModelScope.launch {
            _gistStarred.value = repository.getStarredGists()
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GistStarredViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GistStarredViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}