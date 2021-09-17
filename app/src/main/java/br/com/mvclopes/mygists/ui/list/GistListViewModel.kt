package br.com.mvclopes.mygists.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mvclopes.mygists.model.Gist

class GistListViewModel: ViewModel() {

    private var _response = MutableLiveData<String>()
    val response: LiveData<String> get() = _response

    private var _listGists = MutableLiveData<MutableList<Gist>>()
    val listGists: LiveData<MutableList<Gist>> get() = _listGists

    init {
        //Dados fakes pra testar recycler view. Removê-los depois
        mockList()

    }

    private fun mockList() {
        _listGists.value = mutableListOf(
            Gist("1", "mvclopes", "photo 01", true, "Kotlin"),
            Gist("2", "joaozinho", "photo 02", false, "Java"),
            Gist("3", "fulano", "photo 03", true, "Python")
        )
        Log.i("ViewModel", "$listGists - mockList: ${_listGists.value}")
    }


}