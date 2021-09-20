package br.com.mvclopes.mygists.model

import android.os.Parcelable
import br.com.mvclopes.mygists.database.Converters
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val avatar_url: String = "",
    val login: String = "mvclopes",
) : Parcelable