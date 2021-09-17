package br.com.mvclopes.mygists.model

data class Gist(
    val name: String,
    val photoOwner: String,
    val starred: Boolean,
    val gistType: String
) {
}