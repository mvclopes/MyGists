package br.com.mvclopes.mygists.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mvclopes.mygists.model.Gist
import br.com.mvclopes.mygists.network.WebService
import kotlinx.coroutines.launch

class GistListViewModel: ViewModel() {

    private var _response = MutableLiveData<String>()
    val response: LiveData<String> get() = _response

    private var _listGists = MutableLiveData<MutableList<Gist>>()
    val listGists: LiveData<MutableList<Gist>> get() = _listGists

    init {
        //TODO implementar camada de Repositório, de modo que só ela tenha acesso a API
        getPublicGists()
    }

    private fun getPublicGists(){
        viewModelScope.launch {
            try {
                val response = WebService.network.getPublicGists()
                _response.value = response.toString()
                Log.i("Webservice Success", "response: $response")
            } catch (e: Exception) {
                e.printStackTrace()
                _response.value = e.message
                Log.i("Webservice Failure", "response: ${e.message}")
            }
        }
    }


}