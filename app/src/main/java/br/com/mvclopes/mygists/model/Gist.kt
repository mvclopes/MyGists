package br.com.mvclopes.mygists.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gist(val gist: ArrayList<GistItem>): Parcelable