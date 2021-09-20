package br.com.mvclopes.mygists.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_public_gists")
@Parcelize
data class GistItem(
    //TODO adicionar typeConverters a Files e Owner, pois a ROOM não permite referências de objetos entre entidades
    @PrimaryKey
    val id: String,
    val description: String,
    val files: MutableList<File>,
    val owner: Owner,
    var isStarred: Boolean = false
) : Parcelable