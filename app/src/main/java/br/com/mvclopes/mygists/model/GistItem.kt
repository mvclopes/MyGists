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
    @ColumnInfo(name = "description")
    val description: String = "",

    @Ignore
    @Embedded
    @ColumnInfo(name = "files")
    val files: List<File> = listOf(File()),

    @Ignore
    @Embedded
    @ColumnInfo(name = "owner")
    val owner: Owner = Owner(),

    @Ignore
    @ColumnInfo(name = "isStarred")
    var isStarred: Boolean = false
) : Parcelable{

}