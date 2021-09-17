package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Files(
    val file: File
) : Parcelable