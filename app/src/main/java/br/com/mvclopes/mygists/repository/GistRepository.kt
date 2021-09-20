package br.com.mvclopes.mygists.repository

import android.util.Log
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.network.NetworkUtils
import br.com.mvclopes.mygists.network.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GistRepository/*(private val database: GistDatabase)*/ {

//    val allGists: LiveData<List<GistItem>>
//    get() = database.gistDao.getAllGists()

    suspend fun refreshGists(): MutableList<GistItem>{
        var gists = mutableListOf<GistItem>()
        withContext(Dispatchers.IO){
            try {
                val responseApi = WebService.network.getPublicGists()
                Log.i("TAG_Repository", "Response: \n$responseApi")
                gists = NetworkUtils.parseStringToGistList(responseApi)
//                database.gistDao.insertAll(gists)
            }catch (e: Exception){
                Log.e("Gist_Repository", e.message ?: "No internet connection")
            }
        }
        return gists
    }
}