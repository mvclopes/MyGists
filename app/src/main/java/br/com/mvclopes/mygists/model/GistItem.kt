package br.com.mvclopes.mygists.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_public_gists")
@Parcelize
data class GistItem(
    @PrimaryKey
    var id: String = "",
    @Ignore
    val description: String = "",
    @Ignore
    @Embedded
    val files: List<File> = listOf(File()),
    @Ignore
    @Embedded
    val owner: Owner = Owner(),
    @Ignore
    var isStarred: Boolean = false
) : Parcelable{

    fun set_Id(id: String){
        this.id = id
    }
}