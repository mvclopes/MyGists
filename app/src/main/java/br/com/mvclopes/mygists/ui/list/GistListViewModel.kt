package br.com.mvclopes.mygists.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.network.NetworkUtils
import br.com.mvclopes.mygists.network.WebService
import kotlinx.coroutines.launch

class GistListViewModel: ViewModel() {

    private var _gist = MutableLiveData<MutableList<GistItem>>()
    val gist: LiveData<MutableList<GistItem>> get() = _gist

    init {
        //TODO implementar camada de Repositório, de modo que só ela tenha acesso a API
        getPublicGists()
    }

    private fun getPublicGists(){
        viewModelScope.launch {
            try {
                val response = WebService.network.getPublicGists()
                val gist = NetworkUtils.parseStringToGistList(response)
                _gist.value = gist
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}