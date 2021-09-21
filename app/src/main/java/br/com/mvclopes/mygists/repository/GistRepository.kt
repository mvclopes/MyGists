package br.com.mvclopes.mygists.repository

import androidx.lifecycle.LiveData
import br.com.mvclopes.mygists.database.GistDatabase
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.network.NetworkUtils
import br.com.mvclopes.mygists.network.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class GistRepository(private val database: GistDatabase) {

    val allGists: LiveData<List<GistItem>>
        get() = database.gistDao().getAllGists()

    suspend fun refreshGists(): MutableList<GistItem> {
        var gists = mutableListOf<GistItem>()
        withContext(Dispatchers.IO) {
            try {
                val responseApi = WebService.network.getPublicGists()
                Timber.i("Response: \n$responseApi")
                gists = NetworkUtils.parseStringToGistList(responseApi)
                database.gistDao().insertAll(gists)
            } catch (e: Exception) {
                Timber.e(e.message ?: "No internet connection")
            }
        }
        return gists
    }
}