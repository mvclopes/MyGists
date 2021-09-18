package br.com.mvclopes.mygists.network

import br.com.mvclopes.mygists.model.File
import br.com.mvclopes.mygists.model.Files
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.model.Owner
import org.json.JSONArray

object NetworkUtils {

    fun parseStringToGistList(response: String): MutableList<GistItem> {
        val gistItemList = arrayListOf<GistItem>()

        val jsonArray = JSONArray(response)

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)

            val description = jsonObject.getString("description")
            val files = jsonObject.getJSONObject("files")
            val owner = jsonObject.getJSONObject("owner")

            val gistOwner = Owner(
                owner["avatar_url"].toString(),
                owner["login"].toString()
            )

            val gistFiles = Files(
                File(
                    "language",
                    "type"
                )
            )

            val gistItem = GistItem(description, gistFiles, gistOwner)

            gistItemList.add(gistItem)

        }

        return gistItemList
    }

}