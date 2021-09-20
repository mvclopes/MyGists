package br.com.mvclopes.mygists.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.repository.GistRepository
import kotlinx.coroutines.launch

//class GistListViewModel(application: Application): AndroidViewModel(application) {
class GistListViewModel: ViewModel() {

//    private val database = getDataBase(application)
//    private val repository = GistRepository(database)
    private val repository = GistRepository()

    private var _gist = MutableLiveData<MutableList<GistItem>>()
    val gist: LiveData<MutableList<GistItem>> get() = _gist

    init {
        //TODO implementar camada de Repositório, de modo que só ela tenha acesso a API
//        _gist.value = repository.allGists as MutableList<GistItem>
        getPublicGists()
    }

    private fun getPublicGists(){
        viewModelScope.launch {
            _gist.value = repository.refreshGists()
        }
    }
}