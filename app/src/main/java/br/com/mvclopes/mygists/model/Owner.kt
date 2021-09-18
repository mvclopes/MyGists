package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(
    val avatar_url: String = "",
    val login: String = "mvclopes",
) : Parcelable