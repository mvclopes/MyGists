package br.com.mvclopes.mygists.network

import br.com.mvclopes.mygists.model.File
import br.com.mvclopes.mygists.model.GistItem
import br.com.mvclopes.mygists.model.Owner
import org.json.JSONArray

object NetworkUtils {

    fun parseStringToGistList(response: String): MutableList<GistItem> {
        val gistItemList = arrayListOf<GistItem>()

        val jsonArray = JSONArray(response)

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)

            val id = jsonObject.getString("id")
            val description = jsonObject.getString("description")
            val ownerJsonObject = jsonObject.getJSONObject("owner")

            val filesJsonObject = jsonObject.getJSONObject("files")
            val gistFiles = mutableListOf<File>()

            //Caso Gist possua mais de um arquivo associado a ele
            if (filesJsonObject.names().length() > 1){
                filesJsonObject.keys().forEach {
                    gistFiles.add(
                        File(
                            filesJsonObject.getJSONObject(it).getString("filename"),
                            filesJsonObject.getJSONObject(it).getString("language"),
                            filesJsonObject.getJSONObject(it).getString("type")
                        )
                    )
                }
            }else{
                val fileName = filesJsonObject.names().toString()
                val strFileName = fileName.substring(fileName.indexOf("[") + 2, fileName.indexOf("]") - 1)
                val file = filesJsonObject.getJSONObject(strFileName)
                gistFiles.add(
                    File(
                        file.getString("filename"),
                        file.getString("language"),
                        file.getString("type")
                    )
                )
            }

            val gistOwner = Owner(
                ownerJsonObject.getString("avatar_url"),
                ownerJsonObject.getString("login")
            )

            val gistItem = GistItem(id, description, gistFiles, gistOwner)

            gistItemList.add(gistItem)
        }

        return gistItemList
    }

}