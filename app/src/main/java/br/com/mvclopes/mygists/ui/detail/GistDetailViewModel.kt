package br.com.mvclopes.mygists.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.mvclopes.mygists.model.GistItem

class GistDetailViewModel(gistItem: GistItem): ViewModel() {

    private var _gist = MutableLiveData<GistItem>()
    val gist: LiveData<GistItem> get() = _gist

    init {
        _gist.value = gistItem
    }

    fun setStarredGist(){
        _gist.value?.isStarred = _gist.value?.isStarred != true
    }

    class Factory(private val gistItem: GistItem) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GistDetailViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GistDetailViewModel(gistItem) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}