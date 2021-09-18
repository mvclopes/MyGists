package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class File(
//    val filename: String = "",
    val language: String = "",
    val type: String = "application/json"
) : Parcelable