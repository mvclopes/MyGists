package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Files(
    val file: List<File>
) : Parcelable