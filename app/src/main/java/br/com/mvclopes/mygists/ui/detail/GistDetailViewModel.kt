package br.com.mvclopes.mygists.ui.detail

import android.app.Application
import androidx.lifecycle.*
import br.com.mvclopes.mygists.database.getDataBase
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.repository.GistRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class GistDetailViewModel(gistItem: GistItem, application: Application): AndroidViewModel(application) {

    private var _gist = MutableLiveData<GistItem>()
    val gist: LiveData<GistItem> get() = _gist

    private val database = getDataBase(application)
    private val repository = GistRepository(database)

    init {
        _gist.value = gistItem
    }

    fun setStarredGist(){
        _gist.value?.isStarred = _gist.value?.isStarred != true
        viewModelScope.launch {
            repository.updateStarredGist(
                GistItem(
                    _gist.value!!.id,
                    _gist.value!!.description,
                    _gist.value!!.files,
                    _gist.value!!.owner,
                    _gist.value!!.isStarred,
                )
            )
        }
    }

    class Factory(private val gistItem: GistItem, private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GistDetailViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GistDetailViewModel(gistItem, application) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}