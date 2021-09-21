package br.com.mvclopes.mygists.ui.starred

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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
        //TODO inicializar _gistStarred associando a um método do objeto DAO
        _gistStarred.value = getStarredGist()
    }

    private fun getStarredGist(): MutableList<GistItem>{
        var gists = mutableListOf<GistItem>()
        viewModelScope.launch {
            gists = repository.getStarredGists()
        }
        return gists
    }
}