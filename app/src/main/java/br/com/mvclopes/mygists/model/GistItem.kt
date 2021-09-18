package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GistItem(
    val description: String = "",
    val files: Files = Files(),
    val owner: Owner = Owner(),
) : Parcelable