package br.com.mvclopes.mygists.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_public_gists")
@Parcelize
data class Gist(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "gist")
    val gist: ArrayList<GistItem>,

    @ColumnInfo(name = "isStarred")
    val starred: Boolean = false,
    ): Parcelable