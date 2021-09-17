package br.com.mvclopes.mygists.model

data class Gist(
    val nodeId: String,
    val name: String,
    val photoOwner: String,
    val starred: Boolean,
    val gistType: String
) {
}