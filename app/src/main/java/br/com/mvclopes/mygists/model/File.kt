package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class File(
    val filename: String,
    val language: String,
    val raw_url: String,
    val size: Int,
    val type: String
) : Parcelable