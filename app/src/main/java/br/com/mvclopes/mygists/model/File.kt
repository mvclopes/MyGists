package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class File(
    val filename: String = "",
    val language: String = "",
    val type: String = ""
) : Parcelable