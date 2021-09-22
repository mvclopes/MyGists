package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    var avatar_url: String = "",
    var login: String = ""
) : Parcelable{
}